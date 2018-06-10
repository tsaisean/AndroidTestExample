package com.example.sean.androidtestexample.mockito;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_10 {
    @Mock
    private List annotationMockedList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test10_stubbingConsecutiveCalls () {
        when(annotationMockedList.add("some"))
                .thenReturn(true)
                .thenReturn(false);

        Assert.assertEquals(true, annotationMockedList.add("some"));
        Assert.assertEquals(false, annotationMockedList.add("some"));
        Assert.assertEquals(false, annotationMockedList.add("some"));
    }
}
