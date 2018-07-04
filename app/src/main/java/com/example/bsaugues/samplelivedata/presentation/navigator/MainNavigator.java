package com.example.bsaugues.samplelivedata.presentation.navigator;


import android.support.v4.app.FragmentManager;

import com.example.bsaugues.samplelivedata.R;
import com.example.bsaugues.samplelivedata.presentation.di.annotation.PerActivity;
import com.example.bsaugues.samplelivedata.presentation.ui.fragment.NumberListFragment;

import javax.inject.Inject;

@PerActivity
public class MainNavigator {

    private FragmentManager fragmentManager;

    @Inject
    public MainNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void displayNumberListFragment() {
        fragmentManager.beginTransaction().replace(R.id.main_container, NumberListFragment.newInstance()).commit();
    }
}
