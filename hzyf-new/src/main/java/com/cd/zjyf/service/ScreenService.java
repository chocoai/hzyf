package com.cd.zjyf.service;


import com.cd.hik.carlocation.DeviceGpsStatus;
import com.cd.hik.carlocation.DeviceNode;
import com.cd.hik.carlocation.GpsData;
import com.cd.zjyf.annotation.NoPaging;
import com.cd.zjyf.annotation.ReidsCache;
import com.cd.zjyf.config.ApplicationConfig;
import com.cd.zjyf.enums.ServiceRangeCode;
import com.cd.zjyf.mapper.ScreenMapper;
import com.cd.zjyf.pojo.PageBean;
import com.cd.zjyf.pojo.qc.CarLocationPlayback;
import com.cd.zjyf.pojo.qc.Region;
import com.cd.zjyf.pojo.qr.*;
import com.cd.zjyf.proxy.carlocation.CarlocationClient;
import com.cd.zjyf.utils.Base64Util;
import com.cd.zjyf.utils.CommonUtil;
import com.cd.zjyf.utils.RestTemplateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
@ReidsCache
@NoPaging
public class ScreenService {

	
	@Autowired
	private ScreenMapper mapper;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Autowired
	private CarlocationClient carlocationClient;

	private static Logger log = LoggerFactory.getLogger(ScreenService.class);

	@Value("${HEADFRAME}")
	private String headFrame;



	public List<OneMonthSJ>  listYFZLByOneMonth(Region region) {
		return mapper.listYFZLByOneMonth(region);
	}


	public LXobj  listYFZLByOne(Region region) {
		List<LX> lxs = mapper.listYFZLByOne(region);
		if(lxs.size()==0) return null;
		LX total = lxs.get(lxs.size()-1);
		lxs.remove(lxs.size()-1);//移除总数的那个值
		float zCount = total.getCount();
		//设置LXobj作为返回对象
		LXobj lXobj = new LXobj();
		lXobj.setLxs(CommonUtil.getListRangValue(lxs));
		lXobj.setzCount(zCount);
		return lXobj;
	}




	public List<DLXX>  listDLXX(Region region) {
		//对于相同单位根据单位id相同做去重处理
		List<DLXX> list = CommonUtil.distinctBySet(mapper.listDLXX(region));
		//对类型是3 接收员的人从redis缓存中提取坐标
		for(DLXX d:list) {
			if(!d.getZdType().equals(ServiceRangeCode.ZDTYPE_SJY.getCode())) continue;

			if(d.getRyzp()!=null) {
				//d.setHeadFrame(headFrame);
				try {
					d.setRyzp(Base64Util.encode(RestTemplateUtil.getByte(d.getRyzp())));
				} catch (IOException e) {
					log.error("人员照片转base64异常", e);
				}
			}

			String zb =  redisTemplate.boundValueOps(d.getId()).get();
			if(zb!=null&&zb.contains(",")) {
				d.setLongitude(zb.split(",")[0]);
				d.setLatitude(zb.split(",")[1]);
			}
		}
		return list;
	}


	private String translate(String path){

		return  null;
	}

/*	public List<DLXX>  listDWinfo(Region region) {
		//对于相同单位根据单位id相同做去重处理，一定要通过java去重，sql中去不了
		return CommonUtil.distinctBySet(mapper.listDWinfo(region));
	}*/

	public List<DLXX>  listDWinfo(Region region) {
		//对于相同单位根据单位id相同做去重处理，一定要通过java去重，sql中去不了
		List<DLXX> dlxxes = CommonUtil.distinctBySet(mapper.listDWinfo(region));
		//暂存点
		List<DLXX> zcd = dlxxes.stream().filter(dlxx -> ServiceRangeCode.ZDTYPE_ZCD.getCode().equals(dlxx.getZdType())).collect(toList());

		//诊所
		List<DLXX> zs = dlxxes.stream().filter(dlxx -> ServiceRangeCode.ZDTYPE_CSD.getCode().equals(dlxx.getZdType())).collect(toList());

	/*	dlxxes.stream().filter(dlxx -> ServiceRangeCode.ZDTYPE_ZCD.getCode().equals(dlxx.getZdType())).forEach(
				dlxx -> dlxx.setClinics(zs.stream().filter(c->c.getZcdid().equals(dlxx.getId())).collect(toList()))
		);*/

		zcd.stream().forEach(
				dlxx -> dlxx.setClinics(zs.stream().filter(c->c.getZcdid().equals(dlxx.getId())).collect(toList()))
		);

		return  zcd;

	}


/*	public List<DLXX>  listDWinfo(Region region) {
		//对于相同单位根据单位id相同做去重处理，一定要通过java去重，sql中去不了
		List<DLXX> dlxxes = CommonUtil.distinctBySet(mapper.listZCD(region));
		for (DLXX dlxx:dlxxes){
			region.setId(dlxx.getId());
			List<DLXX> dlxxes1 = CommonUtil.distinctBySet(mapper.listZC(region));
			dlxx.setClinics(dlxxes1);
		}
		return dlxxes;

	}*/



	//查询本地区长期未收集单位列表，取前十条(取消10条，显示所有，前端去做滚动操作)
	public List<DWnocollect>  listDWnocollect(Region region) {
		//PageHelper.startPage(ApplicationConfig.pageNum,ApplicationConfig.pageSize);
		region.setSqlSegment(getLONG_NOCOLLECT_DAYS(ApplicationConfig.LONG_NOCOLLECT_DAYS));
		PageHelper.startPage(1, 5);
		return mapper.listDWnocollect(region);
	}

	private String getLONG_NOCOLLECT_DAYS(String str) {
		return mapper.selectConfig(str);
	}





	public PageBean<SJQK2>  listDWsjqk2(Region r) {
		String yljglx = mapper.preListDWsjqk(r);//这里的查询抵消了拦截器的分页，所有下面还得再分一次
		if(ServiceRangeCode.ZCD.getCode().equals(yljglx)) {
			r.setSqlSegment("zcdid");
		}else {
			r.setSqlSegment("csdid");
		}
		Page<?> page = PageHelper.startPage(r.getPage(), r.getSize());
		return CommonUtil.getPageBean(CommonUtil.getListRangValue(mapper.listDWsjqk2(r)),page);
	}


	//地区下拉
	public List<AreaDropdown>  areaDropdown(Region region) {
		return mapper.areaDropdown(region);
	}

	//地区年总收集重量（清算时间）
	public String  yearTotalZL(Region region) {
		return mapper.yearTotalZL(region);
	}

	//16年开始近5年的垃圾收集情况和单位数量(清算时间)
	public List<QST>  qst(Region region) {
		return mapper.qst(region);
	}

	//实际接收情况
	@ReidsCache(false)
	public List<SJSJQK>  sjjsqk(Region region) {
		PageHelper.startPage(1, 5);
		return mapper.sjjsqk(region);
	}


	//地区产生点列表
	public PageBean<CSDlist>  csdList(Region r) {
		Page<?> page = PageHelper.startPage(r.getPage(), r.getSize());
		return CommonUtil.getPageBean(mapper.csdList(r),page);
	}


	//地区暂存点列表
	public PageBean<ZCDlist>  zcdList(Region r) {
		Page<?> page = PageHelper.startPage(r.getPage(), r.getSize());
		return CommonUtil.getPageBean(mapper.zcdList(r),page);
	}


	//今年收集各地区重量
	public List<AreaZL>  areaZL(Region region) {
		return mapper.areaZL(region);
	}

	//智能监管
	public ZNJG znjg(Region region) {

		ZNJG znjg = mapper.znjg(region);

		List<DeviceNode> devTreeInfo = carlocationClient.getDevTreeInfo();

		znjg.setCar(devTreeInfo.size());

		return znjg;
	}


	/**
	 * 车辆实时定位
	 * @param region
	 * @return
	 */
	@ReidsCache(false)
	public List<CarLocation>  carLocation() {
		List<CarLocation> carLocations=new ArrayList<>();
		List<DeviceNode> devTreeInfo = carlocationClient.getDevTreeInfo();
		devTreeInfo.stream().forEach(d->{
			DeviceGpsStatus devGpsStatus = carlocationClient.getDevGpsStatus(d.getDeviceaccount().getValue());
			GpsData gpsData = devGpsStatus.getGpsData().getValue();
			CarLocation carLocation = new CarLocation();
			carLocation.setLng(CommonUtil.getLocation(gpsData.getLongitude().getValue()));
			carLocation.setLat(CommonUtil.getLocation(gpsData.getLatitude().getValue()));
			carLocation.setDevicename(d.getDevicename().getValue());//车牌
			carLocation.setDeviceStatus(devGpsStatus.getDeviceStatus());
			carLocation.setReceiveTime(gpsData.getReceiveTime().getValue());
			carLocations.add(carLocation);
		});
		return carLocations;
	}


	//回放
	public List<CarLocation>  carLocationPlayback(CarLocationPlayback carLocationPlayback) {

		return mapper.carLocationPlayback(carLocationPlayback);

	}


}

