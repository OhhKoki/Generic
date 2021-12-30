package com.example;

/**
 * 实现类也是泛型类，那么实现类和接口的泛型类型需要保持一致
 * @param <E>
 */
@SuppressWarnings("all")
public class GenericThrid<V,T> implements GenericInterface<T> {

    private V value;

    public GenericThrid(V value) {
        this.value = value;
    }

    public V getValue() {
        return this.value;
    }

    @Override
    public T getKey() {
        return null;
    }

}
