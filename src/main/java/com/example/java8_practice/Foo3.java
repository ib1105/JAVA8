package com.example.java8_practice;

import java.util.function.Function;

public class Foo3 {
    public static void main(String[] args) {
        //Function<Integer,Integer> 클래스의 plus라는 객체를 만들고 메서드에 i를 넣어서 결과값 i + 10 을 반환
        Function<Integer,Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        plus10.compose(multiply2); // *2 -> 결과값에 +10
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(2)); //결과값 14

        System.out.println(plus10.andThen(multiply2).apply(2));

        //기본적으로 제공하는 함수형 인터페이스를 통해 굳이 클래스를 생성 하지 않고서도 사용할 수 있다.

    }
}
