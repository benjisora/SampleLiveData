package com.example.bsaugues.samplelivedata.presentation.di.module.fragment;

import android.arch.lifecycle.Lifecycle;

import com.example.bsaugues.samplelivedata.presentation.di.annotation.DIValues;
import com.example.bsaugues.samplelivedata.presentation.di.annotation.PerFragment;
import com.example.bsaugues.samplelivedata.presentation.ui.fragment.BaseFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseFragmentModule {

    @PerFragment
    @Provides
    @Named(DIValues.FRAGMENT_LIFECYCLE_KEY)
    public Lifecycle lifecycle(BaseFragment fragment) {
        return fragment.getLifecycle();
    }
}
