package com.example.daggermig_poc.base;

import android.content.Context;

import com.example.daggermig_poc.ui.home.MainActivityComponent;
import com.example.daggermig_poc.ui.navigation.NavigationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {StorageModule.class, ApplicationSubComponents.class})
public interface ApplicationComponent {

    MainActivityComponent.Factory getMainActivityComp();

    @Component.Factory
    interface Factory {
        ApplicationComponent getApp(@BindsInstance Context context);
    }
}
