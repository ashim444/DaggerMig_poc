package com.example.daggermig_poc.base;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface UserStorage {

    Single<Boolean> addString(String value, String key);

    String getString(String key);

    void addData();
}
