package com.example.common;

public class TapCounter {
    private int count;

    public TapCounter() {
        count = 0;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void reset() {
        count = 0;
    }
}
