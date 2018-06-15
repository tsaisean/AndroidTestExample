package com.example.sean.androidtestexample.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;

/**
 * Created by Sean on 2017/9/18.
 */

/**
 * 32. Better generic support with deep stubs (Since 1.10.0) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#better_generic_support_with_deep_stubs">Better generic support with deep stubs</a>
 */
public class MockitoTest_32 {

    class Lines extends ArrayList<Integer> {
        // ...
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test32_genericSupportWithDeepStubs () {
        Lines lines = mock(Lines.class, RETURNS_DEEP_STUBS);

        // Now Mockito understand this is not an Object but a Line
        Assert.assertTrue(lines.iterator().next() instanceof Integer);
    }

    @Test
    public void test32_genericSupportWithoutDeepStubs () {
        Lines lines = mock(Lines.class);

        Assert.assertSame(lines.iterator(), null);
    }
}
