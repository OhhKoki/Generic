package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用泛型类
 */
@SuppressWarnings("all")
public class GenericTest {

    @Test
    public void test01() {
        // JDK8 以前
        Generic<String> generic1 = new Generic<String>("hello world");
        System.out.println(generic1.getKey());

        // JDK7 以后
        Generic<Integer> generic2 = new Generic<>(100);    // 自动装箱
        System.out.println(generic2.getKey());

        // 泛型类在创建对象时，如果没有指定泛型类型，则按照 Object 类型处理
        Generic generic3 = new Generic(true);
        System.out.println(generic3.getKey());

        // 注意：泛型必须是引用类型，即：泛型不支持基本数据类型
//        Generic<int> generic4 = new Generic<int>(100);

        // 泛型类型在逻辑上可以看成是多个不同的类型，但实际上都是相同类型
        System.out.println(generic1.getClass() == generic2.getClass());
    }

    /**
     * 子类也是泛型类，子类和父类的泛型类型要一致
     */
    @Test
    public void test02() {
        ChildFirst<String> childFirst = new ChildFirst<>();
        childFirst.setValue("hello");
        System.out.println(childFirst.getValue());
    }

    /**
     * 子类不是泛型类，父类要明确泛型的数据类型（如果指定泛型类型，默认使用 Object 类型）
     */
    @Test
    public void test03() {
        ChildSecond childSecond = new ChildSecond();
        childSecond.setValue("hello");
        System.out.println(childSecond.getValue());
    }

    /**
     * 实现类也是泛型类，那么实现类和接口的泛型类型需要保持一致
     */
    @Test
    public void test04() {
        GenericThrid<Integer, String> genericThrid = new GenericThrid<>(100);
        System.out.println(genericThrid.getValue());
        System.out.println(genericThrid.getKey());
    }

    /**
     * 实现类不是泛型类，那么接口要明确指定泛型类型
     */
    @Test
    public void test05() {
        GenericFourth genericFourth = new GenericFourth();
        System.out.println(genericFourth.getKey());
    }

    /**
     * 泛型方法
     */
    @Test
    public void test06() {
        List list = new ArrayList();
        list.add("mysql");
        list.add("oracle");
        list.add("postgresql");
        printList(list);
    }

    public <T> void printList(List<String> list) {
        list.stream().forEach(System.out::println);
    }

    /**
     * 泛型通配符
     */
    @Test
    public void test07() {
        Box<Number> box = new Box<>();
        box.setValue(100);
        showBox1(box);
    }

    public static void showBox1(Box<Number> box) {
        Number value = box.getValue();
        System.out.println(value);
    }

    /**
     * 泛型通配符
     */
    @Test
    public void test08() {
        Box<Integer> box = new Box<>();
        box.setValue(100);
//        showBox2(box);
    }

    public static void showBox2(Box<Number> box) {
        Number value = box.getValue();
        System.out.println(value);
    }

    /**
     * 泛型通配符
     */
    @Test
    public void test09() {
        Box<Integer> box = new Box<>();
        box.setValue(100);
        showBox3(box);
    }

    public static void showBox3(Box<Integer> box) {
        Number value = box.getValue();
        System.out.println(value);
    }

    /**
     * 泛型通配符
     */
    @Test
    public void test10() {
        Box<Integer> box = new Box<>();
        box.setValue(100);
        showBox4(box);
    }

    // 使用泛型通配符，用于代替具体的类型实参
    public static void showBox4(Box<?> box) {
        Object value = box.getValue();
        System.out.println(value);
    }

    /**
     * 泛型通配符上限
     */
    @Test
    public void test11() {
        Box<Integer> box = new Box<>();
        box.setValue(100);
        showBox5(box);
    }

    // ? extends Number - > Box 的泛型只能是 Number 或者 Number 的子类
    public static void showBox5(Box<? extends Number> box) {
        Object value = box.getValue();
        System.out.println(value);
    }

    /**
     * 测试类型通配符上限
     */
    @Test
    public void test12() {
        List<Annimal> annimals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<BabyCat> babyCats = new ArrayList<>();
//        showAnnimal1(annimals);
        showAnnimal1(cats);
        showAnnimal1(babyCats);
    }

    /**
     * 设置的类型通配符上限为 Cat，那么调用该方法时，泛型的类型只能是 Cat 或者 Cat 的子类
     * @param list
     */
    public static void showAnnimal1(List<? extends Cat> list) {
        list.stream().forEach(System.out::println);
    }


    /**
     * 设置的类型通配符上限为 Cat，那么调用该方法时，泛型的类型只能是 Cat 或者 Cat 的子类
     * @param list
     */
    public static void showAnnimal2(List<? extends Cat> list) {
//        list.add(new Cat());
//        list.add(new BabyCat());
        list.stream().forEach(System.out::println);
    }

    /**
     * 测试实参类型 super
     */
    @Test
    public void test13() {
        List<Annimal> annimals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<BabyCat> babyCats = new ArrayList<>();
        showAnnimal3(annimals);
        showAnnimal3(cats);
//        showAnnimal3(babyCats);
    }

    /**
     * 设置的类型通配符下限为 Cat，那么调用该方法时，泛型的类型只能是 Cat 或者 Cat 的父类
     * @param list
     */
    public static void showAnnimal3(List<? super Cat> list) {
        list.stream().forEach(System.out::println);
    }

    /**
     * 设置的类型通配符下限为 Cat，那么调用该方法时，泛型的类型只能是 Cat 或者 Cat 的父类
     * @param list
     */
    public static void showAnnimal4(List<? super Cat> list) {
//        list.add(new Annimal());
        list.add(new Cat());
        list.add(new BabyCat());
        list.stream().forEach(System.out::println);
    }

}
