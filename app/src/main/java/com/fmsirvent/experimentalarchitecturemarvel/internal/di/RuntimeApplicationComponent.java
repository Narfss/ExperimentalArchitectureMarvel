package com.fmsirvent.experimentalarchitecturemarvel.internal.di;


import com.fmsirvent.experimentalarchitecturemarvel.Application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        RuntimeApplicationModule.class,
})
public interface RuntimeApplicationComponent extends ApplicationComponent {
    void inject(Application application);
}
