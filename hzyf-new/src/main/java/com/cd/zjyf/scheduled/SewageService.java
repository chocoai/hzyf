package com.cd.zjyf.scheduled;



import com.cd.zjyf.bean.YlwsJbxx;
import com.cd.zjyf.bean.YlwsJbxxExample;
import com.cd.zjyf.bean.YlwsUpload;
import com.cd.zjyf.component.StringOfYearQuery;
import com.cd.zjyf.enums.ServiceRangeCode;

import com.cd.zjyf.mapper.YlwsJbxxMapper;
import com.cd.zjyf.mapper.YlwsUploadMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.List;

/**
 * 汽车定位相关，包括定时保存坐标和定时删除相关数据表等
 */

@Service
public class SewageService {

	private Logger log = LoggerFactory.getLogger(SewageService.class);



	@Autowired
	private YlwsJbxxMapper ylwsJbxxMapper;

	@Autowired
	private YlwsUploadMapper ylwsUploadMapper;

	@Autowired
	private StringOfYearQuery stringOfYearQuery;

	/**
	 * 每季度新增污水记录上传表数据
	 */
	@Scheduled(cron = "0 0 1  1 1,4,7,10 ?") //每个季度的第一个月的一号的1:00:00 执行一次
	//@Scheduled(cron = "0 00 15 ? * *"  )//TODO
	public void addSewage(){
		log.info("定时插入污水数据");
		YlwsJbxxExample ylwsJbxxExample = new YlwsJbxxExample();
		ylwsJbxxExample.createCriteria().andIsSewageEqualTo(ServiceRangeCode.SEWAGE_Y.getCode());
		List<YlwsJbxx> ylwsJbxxes = ylwsJbxxMapper.selectByExample(ylwsJbxxExample);
		ylwsJbxxes.stream().forEach(ylwsJbxx -> {
			YlwsUpload ylwsUpload = new YlwsUpload();
			ylwsUpload.setYljgid(ylwsJbxx.getId());
			ylwsUpload.setYear(String.valueOf(LocalDate.now().getYear()));
			ylwsUpload.setQuarter(LocalDate.now().query(stringOfYearQuery));
			ylwsUploadMapper.insertSelective(ylwsUpload);
		});


	}



	/*static class StringOfYearQuery implements TemporalQuery<String> {
		@Override
		public String queryFrom(TemporalAccessor temporal) {
			LocalDate now = LocalDate.from(temporal);

			if (now.isBefore(now.with(Month.APRIL).withDayOfMonth(1))) {
				return "1";
			} else if (now.isBefore(now.with(Month.JULY).withDayOfMonth(1))) {
				return "2";
			} else if (now.isBefore(now.with(Month.NOVEMBER).withDayOfMonth(1))) {
				return "3";
			} else {
				return "4";
			}
		}

	}*/
}
