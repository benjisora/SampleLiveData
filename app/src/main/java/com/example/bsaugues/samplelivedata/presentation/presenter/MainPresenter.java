package com.example.bsaugues.samplelivedata.presentation.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.util.Log;

import com.example.bsaugues.samplelivedata.presentation.di.annotation.DIValues;

import javax.inject.Inject;
import javax.inject.Named;

public class MainPresenter extends BasePresenter {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(@Named(DIValues.ACTIVITY_LIFECYCLE_KEY) Lifecycle lifecycle, Context context) {
        super(lifecycle, context);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Log.d(TAG, "Activity created, event received in " + this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.d(TAG, "Activity destroyed, event received in " + this);
    }
}
