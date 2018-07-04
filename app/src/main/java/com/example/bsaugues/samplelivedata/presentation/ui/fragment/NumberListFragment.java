package com.example.bsaugues.samplelivedata.presentation.ui.fragment;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.bsaugues.samplelivedata.R;
import com.example.bsaugues.samplelivedata.presentation.presenter.NumberListPresenter;

import javax.inject.Inject;

import butterknife.BindView;

public class NumberListFragment extends BaseFragment {

    @Inject
    NumberListPresenter numberListPresenter;

    @BindView(R.id.fragment_number_list_text)
    TextView text;

    public static NumberListFragment newInstance() {
        return new NumberListFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        numberListPresenter.startNumberCount();
    }

    @Override
    int getLayoutId() {
        return R.layout.fragment_number_list;
    }

    @Override
    void initObservers() {
        numberListPresenter.getNumberListLiveData().observe(this, new Observer<Long>() {
                    @Override
                    public void onChanged(@Nullable Long value) {
                        text.setText(value != null ? value.toString() : "");
                    }
                }
        );
    }
}
