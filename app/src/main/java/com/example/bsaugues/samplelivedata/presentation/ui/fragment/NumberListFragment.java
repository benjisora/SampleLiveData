package com.example.bsaugues.samplelivedata.presentation.ui.fragment;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.bsaugues.samplelivedata.R;
import com.example.bsaugues.samplelivedata.presentation.viewmodel.NumberListViewModel;

import butterknife.BindView;

public class NumberListFragment extends BaseVMFragment<NumberListViewModel> {

    @BindView(R.id.fragment_number_list_text)
    TextView text;

    public static NumberListFragment newInstance() {
        return new NumberListFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            //First launch
            viewModel.startNumberCount();
        }
    }

    @Override
    Class<NumberListViewModel> getViewModelClass() {
        return NumberListViewModel.class;
    }

    @Override
    int getLayoutId() {
        return R.layout.fragment_number_list;
    }

    @Override
    void initObservers() {
        viewModel.getNumberListLiveData().observe(this, new Observer<Long>() {
                    @Override
                    public void onChanged(@Nullable Long value) {
                        text.setText(value != null ? value.toString() : "");
                    }
                }
        );
    }
}
