package com.example.java8_practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        //메서드래퍼런스 :: 컬런 2개 쳐져있는 것.
        /*
        public static String hi(String name) {
            return "hi " + name;
        }
        */
        //이 것과 같다, 즉, Greeting 클래스의 hi메서드를 사용하는 것이다. 이것이 스태틱 메소드 참조 이다.
        UnaryOperator<String> hi = Greeting::hi;

        //문자를 받지않는 생성자를 참조
        Supplier<Greeting> newGreeting = Greeting::new;

        /*
        public Greeting(String name) {
            this.name = name;
        }
        */
        //이건 문자를 받는 생성자를 참조
        Function<String,Greeting> HelloGreeting = Greeting::new;
        Greeting ib = HelloGreeting.apply("ib");
        System.out.println(ib);

    }
}
