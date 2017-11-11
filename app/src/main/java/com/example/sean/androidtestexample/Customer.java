package com.example.sean.androidtestexample;

import java.util.HashMap;

/**
 * Created by Sean on 2017/9/18.
 */

public class Customer {

    private long id;
    private String name;
    private int level;
    private HashMap<Long, Order> orders;

    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public Order getOrder(long orderId) {
        return orders.get(orderId);
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }
}
