package com.other.finalproject.bean;

/**
 * author: hedianbo.
 * date: 2019-12-30
 * desc:
 */
public class UserBean {

    private String userName;

    private String uEmail;

    public String getUserName() {
        return userName == null ? "" : userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getuEmail() {
        return uEmail == null ? "" : uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }
}
