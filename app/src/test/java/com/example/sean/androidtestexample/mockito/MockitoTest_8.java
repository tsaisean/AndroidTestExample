package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.verifyNoMoreInteractions;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_8 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test8_noMoreInteractions() {
        List mockedListA = mock(List.class);
        mockedListA.add("one");
        mockedListA.add("two");

        verify(mockedListA).add("one");

        //following verification will fail
        verifyNoMoreInteractions(mockedListA);
    }
}
