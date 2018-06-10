package com.example.sean.androidtestexample;

/**
 * Created by Sean on 2017/11/15.
 */

public class Package {
    private final Order order;
    private final String DEFAULT_TYPE = "BOX";

    public Package(Order order) {
        this.order = order;
    }

    public String getType() {
        return DEFAULT_TYPE;
    }

    public Order getOrder() {
        return order;
    }
}
