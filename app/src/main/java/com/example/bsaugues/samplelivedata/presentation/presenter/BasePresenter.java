package com.example.bsaugues.samplelivedata.presentation.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.util.Log;

public abstract class BasePresenter implements LifecycleObserver {

    private static final String TAG = "BasePresenter";

    private Context context;

    public BasePresenter(Lifecycle lifecycle, Context context) {
        this.context = context;
        observe(lifecycle);
    }

    private void observe(Lifecycle lifecycle) {
        Log.d(TAG, "Observing lifecycle from " + this);
        lifecycle.addObserver(this);
    }

}
