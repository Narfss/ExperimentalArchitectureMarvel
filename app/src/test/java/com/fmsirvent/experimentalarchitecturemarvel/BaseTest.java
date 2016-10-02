package com.fmsirvent.experimentalarchitecturemarvel;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public abstract class BaseTest {

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        setup();
    }

    public abstract void setup();
}
