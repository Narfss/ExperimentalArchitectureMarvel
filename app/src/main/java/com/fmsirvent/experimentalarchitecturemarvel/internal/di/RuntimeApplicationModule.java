package com.fmsirvent.experimentalarchitecturemarvel.internal.di;

import android.content.Context;

import com.fmsirvent.experimentalarchitecturemarvel.logic.JobExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;
import com.fmsirvent.experimentalarchitecturemarvel.logic.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        RepositoriesModule.class,
})
public class RuntimeApplicationModule implements ApplicationModule {
    private Context context;

    public RuntimeApplicationModule(Context context) {
        this.context = context;
    }

    @Override @Provides
    public Context provideContext() {
        return context;
    }

    @Override @Provides @Singleton
    public ThreadExecutor provideThreadExecutor() {
        return JobExecutor.getInstance();
    }

    @Override @Provides @Singleton
    public PostExecutionThread providePostExecutionThread() {
        return UIThread.getInstance();
    }
}
