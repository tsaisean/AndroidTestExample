package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_7 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test7_zeroInteractions() {
        List mockedListA = mock(List.class);
        List mockedListB = mock(List.class);

        mockedListA.add("one");

        verifyZeroInteractions(mockedListB);
    }
}
