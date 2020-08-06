package com.example.daggermig_poc.ui.navigation;

import com.example.daggermig_poc.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class NavigationModule {

    @Provides
    @ActivityScope
    Navigator provideScreenNavigator(){
        return new NavigationHandler();
    };

}
