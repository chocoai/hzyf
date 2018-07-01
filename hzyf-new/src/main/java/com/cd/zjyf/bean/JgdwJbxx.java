package com.cd.zjyf.bean;

public class JgdwJbxx {
    private String id;

    private String jgdwmc;

    private String bmjb;

    private String xzqh;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJgdwmc() {
        return jgdwmc;
    }

    public void setJgdwmc(String jgdwmc) {
        this.jgdwmc = jgdwmc == null ? null : jgdwmc.trim();
    }

    public String getBmjb() {
        return bmjb;
    }

    public void setBmjb(String bmjb) {
        this.bmjb = bmjb == null ? null : bmjb.trim();
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh == null ? null : xzqh.trim();
    }

    //把市直辖的编码转化成市级的编码330000000, 330500000, 330500000->330000000, 330500000
    public JgdwJbxx translateXZQH(){
        if(xzqh!=null&&xzqh.split(",").length>1){
            String[] split = xzqh.split(",");
            if(split[split.length-1].equals(split[split.length-2])){
                xzqh= xzqh.substring(0,xzqh.lastIndexOf(","));
            }
        }
        return this;
    }

}