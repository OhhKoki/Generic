package com.example;

/**
 * 实现类不是泛型类，那么接口要明确指定泛型类型（如果指定泛型类型，默认使用 Object 类型）
 */
@SuppressWarnings("all")
public class GenericFourth implements GenericInterface<String> {

    @Override
    public String getKey() {
        return null;
    }

}
