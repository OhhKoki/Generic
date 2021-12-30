package com.example;

/**
 * 子类不是泛型类，父类要明确泛型的数据类型（如果不指定泛型类型，默认使用 Object 类型）
 */
public class ChildSecond extends Parent<String> {

}
