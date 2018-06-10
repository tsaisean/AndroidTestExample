package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_9 {
    @Mock
    private List annotationMockedList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test9_mockAnnotation() {
        // We put MockitoAnnotations.initMocks(this) in setUp().

        annotationMockedList.add("one");
        verify(annotationMockedList).add("one");
    }
}
