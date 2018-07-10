package com.example.bsaugues.samplelivedata.data;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class ContentRepository {

    @Inject
    public ContentRepository() {
        //Intentionally empty
    }

    public Observable<Long> getNumberCountObservable() {
        return Observable.interval(1, TimeUnit.SECONDS);
    }
}
