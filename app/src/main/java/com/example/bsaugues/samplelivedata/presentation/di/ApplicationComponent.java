package com.example.bsaugues.samplelivedata.presentation.di;

import android.app.Application;

import com.example.bsaugues.samplelivedata.MainApplication;
import com.example.bsaugues.samplelivedata.presentation.di.module.ApplicationModule;
import com.example.bsaugues.samplelivedata.presentation.di.module.activity.ActivityInjectorModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        AndroidSupportInjectionModule.class,
        ActivityInjectorModule.class
})
public interface ApplicationComponent {

    void inject(MainApplication mainApplication);

    @Component.Builder
    abstract class Builder {
        @BindsInstance
        public abstract Builder application(Application application);

        public abstract ApplicationComponent build();
    }
}
