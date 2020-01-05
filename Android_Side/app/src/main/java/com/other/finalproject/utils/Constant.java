package com.other.finalproject.utils;

/**
 * author: hedianbo.
 * date: 2019-12-29
 * desc:
 */
public class Constant {

    //public static String baseUrl = "http://10.0.2.2:8080/finalproject/";//模拟器使用这个
    public static String baseUrl = "http://192.168.0.103:8080/finalproject/";//真机用这个

    // 响应情况的key
    public static final String KEY = "ResponseCode";
    // 后台响应正常
    public static final String OK = "200";
    // 用户不存在
    public static final String USER_NOT_EXIST = "201";
    // 数据库响应异常
    public static final String DATABASE_EXCEPTION = "202";
    // 用户名已存在
    public static final String USER_EXIST = "203";
    //用户邮箱已存在
    public static final String EMAIL_EXIST = "204";
    // 收藏不存在
    public static final String FAVORITE_NOT_EXIST = "205";
    // 收藏存在
    public static final String FAVORITE_EXIST = "206";
    // 后台响应错误
    // 这个标签能直接标识所有的错误和异常
    public static final String ERROR = "404";
}
