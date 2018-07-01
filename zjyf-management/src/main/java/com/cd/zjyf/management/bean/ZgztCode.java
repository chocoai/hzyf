package com.cd.zjyf.management.bean;

public enum ZgztCode {

    ON_GUARD("1","在岗"),
    OFF_GUARD("2","不在岗");

    ZgztCode(String id, String status) {
        this.id = id;
        this.status = status;
    }

    private String id;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
