package com.example.daggermig_poc.ui.second;

import android.view.View;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.example.daggermig_poc.R;
import com.example.daggermig_poc.base.BaseController;
import com.example.daggermig_poc.base.MyApplication;
import com.example.daggermig_poc.databinding.SecondControllerBinding;

import javax.inject.Inject;

public class SecondController extends BaseController {

    @Inject
    SecondPresenter secondPresenter;

    @Inject
    SecondViewModel secondViewModel;

    public static Controller newInstance() {
        return new SecondController();
    }

    @Override
    protected int layoutRes() {
        return R.layout.second_controller;
    }
    private  SecondControllerBinding binding;

    @Override
    protected void onViewBound(View view) {
         binding = (SecondControllerBinding) dataBinding;

    }
}
