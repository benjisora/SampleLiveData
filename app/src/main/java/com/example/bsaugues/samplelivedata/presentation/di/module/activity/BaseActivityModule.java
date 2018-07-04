package com.example.bsaugues.samplelivedata.presentation.di.module.activity;

import android.arch.lifecycle.Lifecycle;
import android.support.v4.app.FragmentManager;

import com.example.bsaugues.samplelivedata.presentation.di.annotation.DIValues;
import com.example.bsaugues.samplelivedata.presentation.di.annotation.PerActivity;
import com.example.bsaugues.samplelivedata.presentation.ui.activity.BaseActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseActivityModule {

    @PerActivity
    @Provides
    @Named(DIValues.ACTIVITY_LIFECYCLE_KEY)
    public Lifecycle lifecycle(BaseActivity activity) {
        return activity.getLifecycle();
    }

    @PerActivity
    @Provides
    public FragmentManager provideSupportFragmentManager(BaseActivity activity) {
        return activity.getSupportFragmentManager();
    }
}
