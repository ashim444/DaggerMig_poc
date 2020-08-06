package com.example.daggermig_poc.ui.first;


import com.example.daggermig_poc.di.ScreenScope;
import com.jakewharton.rxrelay2.BehaviorRelay;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

@ScreenScope
public class FirstViewModel {
    private BehaviorRelay<Boolean> saveDataRelay;
    @Inject
    public FirstViewModel() {
        saveDataRelay = BehaviorRelay.create();
    }

    public Observable<Boolean> stringRelay(){
        return saveDataRelay;
    }

    public Consumer<Boolean> stringSaved(){
        return saveDataRelay;
    }

}
