package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_18 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test18_validateMockitoUsage() {
        // https://static.javadoc.io/org.mockito/mockito-core/2.11.0/org/mockito/Mockito.html#framework_validation
    }
}
