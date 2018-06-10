package com.example.sean.androidtestexample.mockito;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.spy;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_12 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test12_stubbingVoidMethods() {
        List spiedList = spy(new LinkedList());

        //let's make clear() do nothing
        Mockito.doNothing().when(spiedList).clear();

        spiedList.add("one");

        //clear() does nothing, so the list still contains "one"
        spiedList.clear();

        Assert.assertEquals(1, spiedList.size());


        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                ((List)invocationOnMock.getMock()).add(1);
                ((List)invocationOnMock.getMock()).add(2);
                return null;
            }
        }).when(spiedList).clear();

        spiedList.clear();

        Assert.assertEquals(3, spiedList.size());
    }
}
