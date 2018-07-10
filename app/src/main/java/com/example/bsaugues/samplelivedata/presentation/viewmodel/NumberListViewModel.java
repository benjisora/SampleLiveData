package com.example.bsaugues.samplelivedata.presentation.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.bsaugues.samplelivedata.data.ContentRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NumberListViewModel extends AndroidViewModel {

    private static final String TAG = "NumberListViewModel";

    private ContentRepository contentRepository;
    private CompositeDisposable disposables;
    private MutableLiveData<Long> numberListLiveData;

    @Inject
    public NumberListViewModel(Application application, ContentRepository contentRepository) {
        super(application);
        this.contentRepository = contentRepository;
        this.disposables = new CompositeDisposable();
        this.numberListLiveData = new MutableLiveData<>();
    }

    @Override
    protected void onCleared() {
        Log.d(TAG, "Activity destroyed, event received in " + this);
        disposables.dispose();
        super.onCleared();
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
                        Log.d(TAG, "value : " + value + "; model: " + this);
                        numberListLiveData.postValue(value);
                    }
                }));
    }

    public MutableLiveData<Long> getNumberListLiveData() {
        return numberListLiveData;
    }
}
