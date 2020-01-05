package com.other.finalproject;

import android.app.Application;

import com.other.finalproject.utils.SpUtil;


public class MainApplication extends Application {

    private static final String TAG = MainApplication.class.getName();

    private static MainApplication mApplication;

    public static synchronized MainApplication getInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
//        DatabaseHelper.getInstance(this);
        SpUtil.init(this);
    }

}
