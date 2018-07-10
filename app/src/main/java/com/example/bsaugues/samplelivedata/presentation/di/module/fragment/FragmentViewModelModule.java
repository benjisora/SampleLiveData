package com.example.bsaugues.samplelivedata.presentation.di.module.fragment;

import android.arch.lifecycle.ViewModel;

import com.example.bsaugues.samplelivedata.presentation.di.annotation.PerFragment;
import com.example.bsaugues.samplelivedata.presentation.di.annotation.ViewModelKey;
import com.example.bsaugues.samplelivedata.presentation.viewmodel.NumberListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class FragmentViewModelModule {

    @PerFragment
    @Binds
    @IntoMap
    @ViewModelKey(NumberListViewModel.class)
    public abstract ViewModel numberListViewModel(NumberListViewModel numberListViewModel);
}
