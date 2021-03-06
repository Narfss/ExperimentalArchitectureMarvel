package com.fmsirvent.experimentalarchitecturemarvel.internal.di;

import android.content.Context;

import com.fmsirvent.experimentalarchitecturemarvel.logic.PostExecutionThread;
import com.fmsirvent.experimentalarchitecturemarvel.logic.ThreadExecutor;

public interface ApplicationModule {
    Context provideContext();
    ThreadExecutor provideThreadExecutor();
    PostExecutionThread providePostExecutionThread();
}
