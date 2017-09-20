package com.example.sean.androidtestexample;

/**
 * Created by Sean on 2017/9/18.
 */

public class Order {
    private long id;
    private Customer customer;
    private float originalTotal;
    private float vipDiscount = 0.8f;

    public Order(long id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public void setOriginalTotal(float originalTotal) {
        this.originalTotal = originalTotal;
    }

    private float getOriginalTotal() {
        return originalTotal;
    }

    public float getTotal() {
        return CustomerUtils.isVIP(customer) ? getOriginalTotal() * vipDiscount : getOriginalTotal();
    }
}
