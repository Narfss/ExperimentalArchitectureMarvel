package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api.result;

import com.fmsirvent.experimentalarchitecturemarvel.BaseTest;

import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

public class DataTest extends BaseTest {
    @Mock List<Object> list;
    @Mock Object object;

    @Override
    public void setup() {
    }

    @Test
    public void shouldBeUniqueResult() {
        doReturn(1).when(list).size();
        Data data = new Data.Builder<>().setResult(list).build();
        boolean uniqueResult = data.isUniqueResult();
        assertTrue(uniqueResult);
    }

    @Test
    public void shouldNotBeUniqueResult() {
        doReturn(2).when(list).size();
        Data data = new Data.Builder<>().setResult(list).build();
        boolean uniqueResult = data.isUniqueResult();
        assertFalse(uniqueResult);
    }

    @Test
    public void shouldReturnFirstResult() {
        doReturn(object).when(list).get(0);
        Data data = new Data.Builder<>().setResult(list).build();
        assertEquals(data.getFirstResult(), object);
    }
}