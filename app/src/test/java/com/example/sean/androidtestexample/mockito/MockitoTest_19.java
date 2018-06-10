package com.example.sean.androidtestexample.mockito;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.BDDMockito.given;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_19 {
    @Mock
    private List annotationMockedList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test19_BDD() {
        // given
        given(annotationMockedList.size()).willReturn(2);

        // when
        int size = annotationMockedList.size();

        // then
        Assert.assertEquals(2, size);
    }
}
