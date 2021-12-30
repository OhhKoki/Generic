package com.example;

@SuppressWarnings("all")
public class StaticAndGenericMethod<T> {

    public static <E> void getClass(E t) {
        System.out.println(t.getClass());
    }

}
