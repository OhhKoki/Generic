package com.example;

import java.lang.reflect.Array;

public class Fruit<T> {

    private T[] array;

    public Fruit(Class<T> clz, int length){
        //通过 Array.newInstance 创建泛型数组
        array = (T[]) Array.newInstance(clz, length);
    }

}
