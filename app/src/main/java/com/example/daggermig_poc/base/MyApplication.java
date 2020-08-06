package com.example.daggermig_poc.base;

import android.app.Application;

public class MyApplication extends Application {

    private ApplicationComponent appComp;

    @Override
    public void onCreate() {
        super.onCreate();
        this.appComp = DaggerApplicationComponent.factory().getApp(this);
    }

    public ApplicationComponent getAppComp() {
        return appComp;
    }
}
