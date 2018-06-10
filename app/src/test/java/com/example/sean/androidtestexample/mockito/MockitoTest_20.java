package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_20 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test20_serializableMocks () {
        // TODO: Not sure how to write an example for this.
        // Ref: https://static.javadoc.io/org.mockito/mockito-core/2.11.0/org/mockito/Mockito.html#serializable_mocks
    }
}
