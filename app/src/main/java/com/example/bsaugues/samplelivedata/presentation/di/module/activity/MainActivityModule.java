package com.example.bsaugues.samplelivedata.presentation.di.module.activity;

import com.example.bsaugues.samplelivedata.presentation.di.annotation.PerActivity;
import com.example.bsaugues.samplelivedata.presentation.di.annotation.PerFragment;
import com.example.bsaugues.samplelivedata.presentation.di.module.fragment.FragmentViewModelModule;
import com.example.bsaugues.samplelivedata.presentation.ui.activity.BaseActivity;
import com.example.bsaugues.samplelivedata.presentation.ui.activity.MainActivity;
import com.example.bsaugues.samplelivedata.presentation.ui.fragment.NumberListFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = {BaseActivityModule.class})
public abstract class MainActivityModule {

    @PerActivity
    @Binds
    public abstract BaseActivity baseActivity(MainActivity mainActivity);

    @PerFragment
    @ContributesAndroidInjector(modules = {FragmentViewModelModule.class})
    public abstract NumberListFragment numberListFragmentInjector();

}
