package com.example.daggermig_poc.ui.first;

import android.annotation.SuppressLint;

import com.example.daggermig_poc.base.UserStorage;
import com.example.daggermig_poc.di.ScreenScope;
import com.example.daggermig_poc.ui.navigation.Navigator;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@ScreenScope
public class FirstPresenter {
    private final UserStorage userStorage;
    private final Navigator navigator;
    private final FirstViewModel viewModel;

    @Inject
    public FirstPresenter(UserStorage userStorage, Navigator navigator, FirstViewModel viewModel) {
        this.userStorage = userStorage;
        this.navigator = navigator;
        this.viewModel = viewModel;
    }

    @SuppressLint("CheckResult")
    public void saveString(String data) {
        userStorage.addString(data, "data").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success -> viewModel.stringSaved().accept(true));
    }

    public void navigateToSecondScreen() {
        navigator.navigateToSecondScreen();
    }


}
