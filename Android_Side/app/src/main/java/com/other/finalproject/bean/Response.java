package com.other.finalproject.bean;

/**
 * author: hedianbo.
 * date: 2019-12-30
 * desc:
 */
public class Response {

    private String responseCode;

    public String getResponseCode() {
        return responseCode == null ? "" : responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
