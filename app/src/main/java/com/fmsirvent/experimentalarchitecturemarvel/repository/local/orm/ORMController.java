package com.fmsirvent.experimentalarchitecturemarvel.repository.local.orm;

import com.fmsirvent.experimentalarchitecturemarvel.Application;
import com.fmsirvent.experimentalarchitecturemarvel.repository.local.ORMHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;

public class ORMController {
    protected ORMHelper getHelper() {
        return OpenHelperManager.getHelper(Application.getContext(), ORMHelper.class);
    }
}
