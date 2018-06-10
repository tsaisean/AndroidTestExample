package com.example.sean.androidtestexample.mockito;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_11 {
    @Mock
    private List annotationMockedList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test11_stubbingWithCallbacks() {
        when(annotationMockedList.add(1)).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                return true;
            }
        });

        Assert.assertEquals(true, annotationMockedList.add(1));
        Assert.assertEquals(false, annotationMockedList.add(2));
        Assert.assertEquals(false, annotationMockedList.add("some"));
    }
}
