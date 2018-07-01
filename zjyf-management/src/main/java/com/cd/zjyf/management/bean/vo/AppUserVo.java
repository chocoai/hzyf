package com.cd.zjyf.management.bean.vo;

import org.springframework.beans.factory.annotation.Autowired;

import com.cd.zjyf.management.bean.IsshCode;
import com.cd.zjyf.management.bean.RylxCode;
import com.cd.zjyf.management.dao.AppUserDao;
import com.cd.zjyf.management.pojo.AppUser;

import io.swagger.annotations.ApiModelProperty;

public class AppUserVo {
	
	@ApiModelProperty("用户id(账号)")
	String id;
	
	@ApiModelProperty("人员姓名/运输公司名称")
	String xm;
	
	
	@ApiModelProperty("医疗/监管/运输公司 机构名称")
	String jgName;
	
	@ApiModelProperty("审核状态名称")
	String isshName;
	
	@ApiModelProperty("人员类型名称")
	String rylxName;
	
	@Autowired
	private AppUserDao appUserDao;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getJgName() {
		return jgName;
	}

	public void setJgName(AppUser appUser) {
		
		if (null == appUser) {
			throw new IllegalArgumentException("用户不能为空");
		}
		
		//获取人员类型id
		String rylx = appUser.getRole().getId();
		
		//根据人员类型，给机构名称属性赋值
		
		if (RylxCode.HANDOVEROR.getRylx().equals(rylx)) {
			this.jgName = appUser.getYlwsJbxx().getDwmc();
		
		} else if (RylxCode.RECEIVER.getRylx().equals(rylx)) {
			this.jgName = appUser.getYlwsJbxx().getDwmc();
		
		} else if (RylxCode.TRANSPORTER.getRylx().equals(rylx)) {
			String ysgsid = appUser.getYsgsid();
			AppUser transportAdmin = appUserDao.findOne(ysgsid);
			String transportCompanyName = transportAdmin.getXm();
			this.jgName = transportCompanyName;
		
		} else if (RylxCode.VIEWER.getRylx().equals(rylx)) {
			this.jgName = appUser.getJgdwJbxx().getJgdwmc();
		
		} else if (RylxCode.HOSPITALADMIN.getRylx().equals(rylx)) {
			this.jgName = appUser.getYlwsJbxx().getDwmc();
		
		} else if (RylxCode.VIEWERADMIN.getRylx().equals(rylx)) {
			this.jgName = appUser.getJgdwJbxx().getJgdwmc();
		
		} else if (RylxCode.TRANSPORTADMIN.getRylx().equals(rylx)) {
			this.rylxName = RylxCode.TRANSPORTADMIN.getRylxName();
			this.jgName = xm;
		}
	}

	public String getIsshName() {
		return isshName;
	}

	public void setIsshName(String issh) throws Exception{
		if (IsshCode.UNREVIEW.getIssh().equals(issh)) {
			this.isshName = "未审核";
		} else if (IsshCode.PASS.getIssh().equals(issh)) {
			this.isshName = "审核通过";
		} else if (IsshCode.UNPASS.getIssh().equals(issh)) {
			this.isshName = "审核未通过";
		} else if (IsshCode.REVIEW.getIssh().equals(issh)) {
			this.isshName = "待审核";
		} else {
			throw new Exception("审核状态码错误");
		}
	}

	public String getRylxName() {
		return rylxName;
	}

	public void setRylxName(String rylx) {
		
	}
	
}
