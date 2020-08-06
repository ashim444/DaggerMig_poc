package com.example.daggermig_poc.base;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class PocSharedPreference implements UserStorage {
    private final String SHARED_PREF = "shared_pref";
    private SharedPreferences sharedPref;

    @Inject
    public PocSharedPreference(Context context) {
        sharedPref = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
    }

    @Override
    public Single<Boolean> addString(String value, String key) {
        return Observable.fromCallable(() -> {
            sharedPref.edit().putString(key, value).apply();
            return true;
        }).singleOrError();
    }

    @Override
    public String getString(String key) {
        return sharedPref.getString(key, "1");
    }

    @Override
    public void addData() {

    }

}
