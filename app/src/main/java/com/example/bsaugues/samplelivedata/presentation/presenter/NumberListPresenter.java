package com.example.bsaugues.samplelivedata.presentation.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.util.Log;

import com.example.bsaugues.samplelivedata.data.ContentRepository;
import com.example.bsaugues.samplelivedata.presentation.di.annotation.DIValues;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NumberListPresenter extends BasePresenter {

    private static final String TAG = "NumberListPresenter";

    private ContentRepository contentRepository;
    private CompositeDisposable disposables;
    private MutableLiveData<Long> numberListLiveData;

    @Inject
    public NumberListPresenter(@Named(DIValues.FRAGMENT_LIFECYCLE_KEY) Lifecycle lifecycle, Context context, ContentRepository contentRepository) {
        super(lifecycle, context);
        this.contentRepository = contentRepository;
        this.disposables = new CompositeDisposable();
        this.numberListLiveData = new MutableLiveData<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Log.d(TAG, "Activity created, event received in " + this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.d(TAG, "Activity destroyed, event received in " + this);
        disposables.dispose();
    }

    public void startNumberCount() {
        disposables.add(contentRepository.getNumberCountObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Long>() {

                    @Override
                    public void onComplete() {
                        //Intentionally empty
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onNext(Long value) {
                        numberListLiveData.postValue(value);
                    }
                }));
    }

    public MutableLiveData<Long> getNumberListLiveData() {
        return numberListLiveData;
    }
}
