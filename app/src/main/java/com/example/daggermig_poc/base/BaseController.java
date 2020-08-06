package com.example.daggermig_poc.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.ControllerChangeType;
import com.example.daggermig_poc.ui.first.FirstController;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseController extends Controller {
    protected ViewDataBinding dataBinding;
    @Inject
    public Context context;
    private final CompositeDisposable disposables = new CompositeDisposable();
    protected BaseController(@Nullable Bundle args) {
        super(args);
    }

    public BaseController() {

    }
    @Override
    protected void onChangeStarted(@NonNull ControllerChangeHandler changeHandler, @NonNull ControllerChangeType changeType) {
        ((MyApplication) context).getAppComp().getMainActivityComp().getActivityComp().getControllerComponent().create().inject(this);
        super.onChangeStarted(changeHandler, changeType);
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @Nullable Bundle savedViewState) {
        dataBinding = DataBindingUtil.inflate(inflater, layoutRes(), container, false);
        onViewBound(dataBinding.getRoot());
        disposables.addAll(subscriptions());
        return dataBinding.getRoot();
    }

    protected Disposable[] subscriptions() {
        return new Disposable[0];
    }


    @LayoutRes
    protected abstract int layoutRes();

    protected abstract void onViewBound(View view);

    @Override
    protected void onDestroyView(@NonNull View view) {
        disposables.clear();
        super.onDestroyView(view);
        if (dataBinding != null) {
            dataBinding.unbind();
            dataBinding = null;
        }
    }
}
