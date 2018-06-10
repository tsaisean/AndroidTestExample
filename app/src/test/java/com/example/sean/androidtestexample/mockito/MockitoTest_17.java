package com.example.sean.androidtestexample.mockito;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_17 {
    @Mock
    private List annotationMockedList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test17_resettingMocks () {
        when(annotationMockedList.size()).thenReturn(10);

        reset(annotationMockedList);

        Assert.assertEquals(0, annotationMockedList.size());
    }
}
