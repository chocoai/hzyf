package com.cd.zjyf.scheduled;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cd.hik.carlocation.DeviceNode;
import com.cd.hik.carlocation.GpsData;
import com.cd.zjyf.bean.Carlocation;
import com.cd.zjyf.mapper.CarlocationMapper;
import com.cd.zjyf.mapper.ScreenMapper;
import com.cd.zjyf.proxy.carlocation.CarlocationClient;
import com.cd.zjyf.utils.CommonUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 汽车定位相关，包括定时保存坐标和定时删除相关数据表等
 */

@Service
public class CarLocationService {

	private Logger log = LoggerFactory.getLogger(CarLocationService.class);

	@Autowired
	private CarlocationClient carlocationClient;

	@Autowired
	private CarlocationMapper carlocationMapper;


	@Autowired
	private ScreenMapper screenMapper;


	@Value("${CAR_LOCATION.PLAYBACK.DAY}")
	private int day;

	@Value("${BAIDU_API.AK}")
	private String ak;

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 调用百度坐标地址转化接口
	 * @param lng
	 * @param lat
	 * @return
	 * @throws Exception
	 */
	private String[] convert(String lng,String lat) throws Exception {
		String coords=lng+","+lat;

		String url="http://api.map.baidu.com/geoconv/v1/?coords={0}&from=1&to=5&ak={1}";

		url = MessageFormat.format(url, coords, ak);

		String forObject = new RestTemplate().getForObject(url, String.class);

		JSONObject jsonObject = JSONObject.parseObject(forObject);
		if(jsonObject.getInteger("status")!=0){
			log.error("调用百度坐标地址转化接口失败");
			throw  new Exception();
		}

		JSONArray result1 = jsonObject.getJSONArray("result");
		JSONObject result = result1.getJSONObject(0);
		return new String[] {result.getString("x"),result.getString("y")};
	}

	/**
	 * 车辆定位采集
	 */
	@Scheduled(cron = "0/10 3-18 * * * *")
	public void carlocationCollect(){
		List<DeviceNode> devTreeInfo = carlocationClient.getDevTreeInfo();
		devTreeInfo.stream().forEach(d->{
			GpsData devGpsStatus = carlocationClient.getDevGpsStatus1(d.getDeviceaccount().getValue());
			if(devGpsStatus!=null) {
				Carlocation carLocation = new Carlocation();
				String[] coords;
				try {
					coords = convert(CommonUtil.getLocation(devGpsStatus.getLongitude().getValue()), CommonUtil.getLocation(devGpsStatus.getLatitude().getValue()));
				} catch (Exception e) {
					return;//相当于普通for循环的 continue
				}
				carLocation.setLng(coords[0]);
				carLocation.setLat(coords[1]);
				carLocation.setDevicename(d.getDevicename().getValue());//车牌
				carLocation.setDirection(devGpsStatus.getDirection().getValue());
				String receiveTime = devGpsStatus.getReceiveTime().getValue();//采样时间
				try {
					Date receiveTime1 = simpleDateFormat.parse(receiveTime);
					carLocation.setReceiveTime(receiveTime1);
				} catch (ParseException e) {
					log.error("定时任务=>插入汽车经纬度：日期格式转化失败！");
				}
				//MySQLIntegrityConstraintViolationException
				try {
					carlocationMapper.insertSelective(carLocation);
				} catch (Exception e) {
					if(e instanceof MySQLIntegrityConstraintViolationException)
						log.trace("定时任务=>插入汽车经纬度：汽车经纬度重复，不做插入操作！");
				}
			}
		});
	}

	/**
	 * 定时删除一周前的车辆数据
	 */
	@Scheduled(cron = "0 0 3 ? * *"  )//每天3：00执行
	public void removeCarlocation(){
		int count = screenMapper.removeCarlocation(day);
		log.info("定时删除一周前的车辆数据,一共删除了{}条",count);
	}



}
