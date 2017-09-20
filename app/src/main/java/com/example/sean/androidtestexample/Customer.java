package com.example.sean.androidtestexample;

/**
 * Created by Sean on 2017/9/18.
 */

public class Customer {

    private long id;
    private String name;
    private int level;

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
}
