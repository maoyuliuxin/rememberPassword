package com.lin.rememberpassword;

import android.app.Application;
import android.content.Context;

import com.lin.rememberpassword.bean.DaoMaster;
import com.lin.rememberpassword.bean.DaoSession;

/**
 * Created by Administrator on 2017/6/4 0004.
 */

public class MyApplication extends Application {

    public final String BASE_DB_NAME = "remember_password";
    public static DaoSession sDaoSession;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, BASE_DB_NAME, null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        sDaoSession = daoMaster.newSession();
    }

    public static Context getContext() {
        return sContext;
    }

    public static DaoSession getDaoSession() {
        return sDaoSession;
    }
}
