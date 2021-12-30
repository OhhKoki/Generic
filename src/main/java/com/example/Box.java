package com.example;

import lombok.Data;

@SuppressWarnings("all")
@Data
public class Box<T> {

    private T value;

}
