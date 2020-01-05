package com.other.finalproject.bean;

/**
 * author: hedianbo.
 * date: 2019-12-30
 * desc:
 */
public class DownLoadBena {


    /**
     * owner : false
     * downloaded : false
     * ResponseCode : 200
     */

    private boolean owner;
    private boolean downloaded;
    private String responseCode;

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public boolean isDownloaded() {
        return downloaded;
    }

    public void setDownloaded(boolean downloaded) {
        this.downloaded = downloaded;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
