package com.example.streaming_app;

public class video_model {
    String detail,vurl;

    public video_model(String detail, String vurl) {
        this.detail = detail;
        this.vurl = vurl;
    }

    public video_model() {
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }
}
