package com.cd.zjyf.bean;

public class TblYlwsDlxx {
    private String id;

    private String fkid;

    private String longitude;

    private String latitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFkid() {
        return fkid;
    }

    public void setFkid(String fkid) {
        this.fkid = fkid == null ? null : fkid.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }
}