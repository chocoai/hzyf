package com.cd.zjyf.bean;

public class YlwsFile {
    private String id;

    private String uploadid;

    private String path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUploadid() {
        return uploadid;
    }

    public void setUploadid(String uploadid) {
        this.uploadid = uploadid == null ? null : uploadid.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
}