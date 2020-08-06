package com.example.daggermig_poc.ui.first;

import com.example.daggermig_poc.base.BaseController;
import com.example.daggermig_poc.di.ScreenScope;

import dagger.Subcomponent;

@ScreenScope
@Subcomponent
public interface FirstControllerComponent {

    @Subcomponent.Factory
    interface Factory{
        FirstControllerComponent create();
    }

    void inject(BaseController firstController);
}
