package com.example.bsaugues.samplelivedata.presentation.di.module.activity;

import android.support.v4.app.FragmentManager;

import com.example.bsaugues.samplelivedata.presentation.di.annotation.PerActivity;
import com.example.bsaugues.samplelivedata.presentation.ui.activity.BaseActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseActivityModule {

    @PerActivity
    @Provides
    public FragmentManager provideSupportFragmentManager(BaseActivity activity) {
        return activity.getSupportFragmentManager();
    }
}
