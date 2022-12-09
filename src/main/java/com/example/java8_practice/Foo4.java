package com.example.java8_practice;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class Foo4 {
    public static void main(String[] args) {
        //Supplier<Integer> get10 = () -> {10}; 대괄호는 바디라는 뜻인데 바디에 하나만 있을경우 생략 가능하다.
        Supplier<Integer> get10 = () -> 10;

        //BinaryOperator<Integer> sum = (Integer a, Integer b) -> a + b;
        //Integer 생략가능하다. 왜냐하면 이미 BinaryOperator<Integer> 에서 객체선언부에서 integer를 선언해줬기 때문이다.
        BinaryOperator<Integer> sum = (a,b) -> a + b;

    }


}