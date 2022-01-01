package com.example;

/**
 * 演示无限制类型擦除
 * @param <T>
 */
public class Erasure2<T extends Number> {

    public T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

}
