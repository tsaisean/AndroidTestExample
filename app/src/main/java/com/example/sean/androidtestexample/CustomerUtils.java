package com.example.sean.androidtestexample;

/**
 * Created by Sean on 2017/9/18.
 */

public class CustomerUtils {

    public static int VIP_LEVEL = 10;

    public static boolean isVIP(Customer customer) {
        return customer.getLevel() > VIP_LEVEL;
    }
}
