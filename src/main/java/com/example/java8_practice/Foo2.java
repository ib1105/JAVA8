package com.example.java8_practice;

public class Foo2 {

    public static void main(String[] args) {
        //이렇게 바꿀 수도 있다.
        RunSomething2 runSomething2 = (number) -> {
            return number + 10;
        };

        System.out.println(runSomething2.doIt(1));
    }
}
