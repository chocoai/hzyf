package com.cd.zjyf.management.bean;

public enum RylxCode {
	
	HANDOVEROR("1","交接员"),      //交接员
	RECEIVER("2","收集员"),       //收集员
    TRANSPORTER("3","运输人员"),        //运输人员
    VIEWER("4","监督人员"),        //监督人员
    HOSPITALADMIN("5","医院管理员"),        //医院管理员
    VIEWERADMIN("6","监督管理员"),        //监督管理员
    TRANSPORTADMIN("7","运输公司管理员");   //运输公司管理员

	private RylxCode(String rylx, String rylxName) {
		this.rylx = rylx;
		this.rylxName = rylxName;
	}
	
    private String rylx;
    
    private String rylxName;

    public String getRylx() {
        return rylx;
    }

	public String getRylxName() {
		return rylxName;
	}

}
