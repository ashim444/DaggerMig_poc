package com.example.daggermig_poc.ui.home;

import android.app.Activity;

import com.example.daggermig_poc.di.ActivityScope;
import com.example.daggermig_poc.ui.first.FirstControllerComponent;
import com.example.daggermig_poc.ui.navigation.NavigationModule;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {NavigationModule.class})
public interface MainActivityComponent {

    void inject(Activity activity);

    FirstControllerComponent.Factory getControllerComponent();

    @Subcomponent.Factory
    interface Factory {
        MainActivityComponent getActivityComp();
    }
}
