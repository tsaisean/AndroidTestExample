package com.example.sean.androidtestexample.mockito;

import com.example.sean.androidtestexample.Customer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Sean on 2017/9/18.
 */

/**
 * 38. Meta data and generic type retention (Since 2.1.0) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#Meta_Data_And_Generics">Meta data and generic type retention</a>
 */
public class MockitoTest_38 {

    @Mock
    private Customer customer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test38_metaDataAndGenericTypeRetention () throws NoSuchMethodException {
        Class<?> mockType = customer.getClass();

        assert mockType.getDeclaredMethod("getOrders").getGenericReturnType() instanceof ParameterizedType;
    }
}
