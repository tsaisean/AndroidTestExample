package com.example.sean.androidtestexample.junit;

import com.example.sean.androidtestexample.Customer;
import com.example.sean.androidtestexample.CustomerUtils;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Sean on 2017/9/18.
 */
public class CustomerUtilsTest {

    @Test
    public void isVIP() throws Exception {
        Customer customer = new Customer(1, "Sean");
        customer.setLevel(11);

        Assert.assertTrue(CustomerUtils.isVIP(customer));
    }

}