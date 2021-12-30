package com.example;

/**
 * 泛型类定义
 */
@SuppressWarnings("all")
public class Generic<T> {

    // T 是调用者决定的
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "GenericClassTest{" +
                "key=" + key +
                '}';
    }

}
