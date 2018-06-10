package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_5 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test (expected = RuntimeException.class)
    public void test5_stubbingVoidMethodsWithExceptions() {
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        doThrow(new RuntimeException()).when(mockedList).clear();

        //following throws RuntimeException:
        mockedList.clear();
    }
}
