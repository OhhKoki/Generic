package com.example;

import java.util.List;

/**
 * 演示无限制类型擦除
 */
public class Erasure3 {

    public <T> T getObject(T t) {
        return t;
    }

    public <T extends List> T getList(T t) {
        return t;
    }

}
