package com.example.java8_practice;

public class Foo {

    public static void main(String[] args) {
        //익명 내부클래스
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
                System.out.println("Hello1");
            }
        };

        //이 표현을 람다표현식으로 바꿀 수 있다.
        RunSomething runSomething1 = () -> {
            System.out.println("Hello");
            System.out.println("Hello1");
        };
        //실행방법
        runSomething1.doIt();
    }
}
