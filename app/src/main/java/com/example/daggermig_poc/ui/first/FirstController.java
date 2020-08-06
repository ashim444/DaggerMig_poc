package com.example.daggermig_poc.ui.first;

import android.view.View;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.ControllerChangeType;
import com.example.daggermig_poc.R;
import com.example.daggermig_poc.base.BaseController;
import com.example.daggermig_poc.base.MyApplication;
import com.example.daggermig_poc.base.UserStorage;
import com.example.daggermig_poc.databinding.FirstControllerBinding;
import com.example.daggermig_poc.ui.navigation.Navigator;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class FirstController extends BaseController implements View.OnClickListener {

    @Inject
    FirstPresenter firstPresenter;

    @Inject
    FirstViewModel firstViewModel;

    @Inject
    Navigator navigator;

    @Inject
    UserStorage userStorage;
    private FirstControllerBinding binding;

    public static Controller newInstance() {
        return new FirstController();
    }

    @Override
    protected int layoutRes() {
        return R.layout.first_controller;
    }

    @Override
    protected void onViewBound(View view) {
        binding = (FirstControllerBinding) dataBinding;
        binding.button1.setOnClickListener(this);
    }

    @Override
    protected Disposable[] subscriptions() {
        return new Disposable[]{
                firstViewModel.stringRelay()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::navToSecondScreen)
        };
    }

    private void navToSecondScreen(Boolean aBoolean) {
        firstPresenter.navigateToSecondScreen();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                String data = binding.editText1.getText().toString();
                if (!data.isEmpty()) {
                    firstPresenter.saveString(data);
                }
                break;
        }
    }
}
