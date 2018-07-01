package com.cd.zjyf.pojo.qc;

import com.cd.zjyf.pojo.LoginUserInfo;
import com.cd.zjyf.utils.AccountValidatorUtil;

import javax.validation.constraints.Pattern;

public class AppUserQC extends LoginUserInfo {
	
	//用户主键
    private String id;

    private String yljgid;//医疗机构主键
   
    private String yljgmc;//医疗机构名称

    private String xm;//姓名
    
	@Pattern(regexp =AccountValidatorUtil.REGEX_MOBILE, message = "{appUser.sjh.regexp}")
    private String sjh;//手机号

    private String mm;//密码

    private String rylx;//人员类型

    private String jgdwid;//机构单位id

    private String ryzp;//人员照片

    private String zgzt;//在岗状态

    private String issh;//是否审核

    private String wtgyy;//未通过原因

    private String jgdwmc;//监管单位名称
    
    private String xzqh;//行政区划
    
    private String xzqhfn;//行政区划全称
    
    private String access_token;
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getYljgid() {
        return yljgid;
    }

    public void setYljgid(String yljgid) {
        this.yljgid = yljgid == null ? null : yljgid.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh == null ? null : sjh.trim();
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm == null ? null : mm.trim();
    }

    public String getRylx() {
        return rylx;
    }

    public void setRylx(String rylx) {
        this.rylx = rylx == null ? null : rylx.trim();
    }

    public String getJgdwid() {
        return jgdwid;
    }

    public void setJgdwid(String jgdwid) {
        this.jgdwid = jgdwid == null ? null : jgdwid.trim();
    }

    public String getRyzp() {
        return ryzp;
    }

    public void setRyzp(String ryzp) {
        this.ryzp = ryzp == null ? null : ryzp.trim();
    }

    public String getZgzt() {
        return zgzt;
    }

    public void setZgzt(String zgzt) {
        this.zgzt = zgzt == null ? null : zgzt.trim();
    }

    public String getIssh() {
        return issh;
    }

    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }

    public String getWtgyy() {
        return wtgyy;
    }

    public void setWtgyy(String wtgyy) {
        this.wtgyy = wtgyy == null ? null : wtgyy.trim();
    }

	public String getYljgmc() {
		return yljgmc;
	}

	public void setYljgmc(String yljgmc) {
		this.yljgmc = yljgmc;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * @return the jgdwmc
	 */
	public String getJgdwmc() {
		return jgdwmc;
	}

	/**
	 * @param jgdwmc the jgdwmc to set
	 */
	public void setJgdwmc(String jgdwmc) {
		this.jgdwmc = jgdwmc;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getXzqhfn() {
		return xzqhfn;
	}

	public void setXzqhfn(String xzqhfn) {
		this.xzqhfn = xzqhfn;
	}
}