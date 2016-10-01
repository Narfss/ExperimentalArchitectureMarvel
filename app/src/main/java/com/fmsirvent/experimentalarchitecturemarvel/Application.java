package com.fmsirvent.experimentalarchitecturemarvel;

import android.content.Context;

import com.fmsirvent.experimentalarchitecturemarvel.internal.di.ApplicationComponent;
import com.fmsirvent.experimentalarchitecturemarvel.internal.di.DaggerRuntimeApplicationComponent;
import com.fmsirvent.experimentalarchitecturemarvel.internal.di.RuntimeApplicationComponent;
import com.fmsirvent.experimentalarchitecturemarvel.internal.di.RuntimeApplicationModule;

public class Application extends android.app.Application {
    private static Application instance;
    private RuntimeApplicationComponent applicationComponent;

    public Application() {
        instance = this;
    }

    public static Application getInstance() {
        return instance;
    }

    public static Context getContext() {
        return getInstance().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjection();
    }

    private void initializeInjection() {
        applicationComponent =
                DaggerRuntimeApplicationComponent
                        .builder()
                        .runtimeApplicationModule(new RuntimeApplicationModule(this))
                        .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
