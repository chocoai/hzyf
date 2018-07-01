package com.cd.zjyf.bean;

public class Hkdevice {
    private String id;

    private String yljgid;

    private String indexcode;

    private String parentUuid;

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

    public String getIndexcode() {
        return indexcode;
    }

    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode == null ? null : indexcode.trim();
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid == null ? null : parentUuid.trim();
    }
}