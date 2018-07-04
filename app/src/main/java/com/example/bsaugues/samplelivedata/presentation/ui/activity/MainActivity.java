package com.example.bsaugues.samplelivedata.presentation.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.bsaugues.samplelivedata.R;
import com.example.bsaugues.samplelivedata.presentation.navigator.MainNavigator;
import com.example.bsaugues.samplelivedata.presentation.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    MainPresenter mainPresenter;

    @Inject
    MainNavigator mainNavigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            //Activity is first created
            mainNavigator.displayNumberListFragment();
        }
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    void initObservers() {
        // Activity with no logic, Presenter isn't offering liveData to subscribe to, left empty.
    }
}
