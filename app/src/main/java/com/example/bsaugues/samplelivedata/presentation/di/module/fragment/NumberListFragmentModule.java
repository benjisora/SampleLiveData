package com.example.bsaugues.samplelivedata.presentation.di.module.fragment;

import com.example.bsaugues.samplelivedata.presentation.di.annotation.PerFragment;
import com.example.bsaugues.samplelivedata.presentation.ui.fragment.BaseFragment;
import com.example.bsaugues.samplelivedata.presentation.ui.fragment.NumberListFragment;

import dagger.Binds;
import dagger.Module;

@Module(includes = {BaseFragmentModule.class})
public abstract class NumberListFragmentModule {

    @PerFragment
    @Binds
    public abstract BaseFragment baseFragment(NumberListFragment numberListFragment);
}
