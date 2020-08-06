package com.example.daggermig_poc.base;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class StorageModule {

    @Binds
    abstract UserStorage provideStorage(PocSharedPreference sharedPreference);
}
