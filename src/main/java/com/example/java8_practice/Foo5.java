package com.example.java8_practice;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo5 {
    public static void main(String[] args) {
        Foo5 foo5 = new Foo5();
        foo5.run();
    }

    private void run() {
        //로컬변수는 final 이거나 effective final 인 경우만 참조할 수 있다.
        //effective final : final을 안적어도 사실상 final인 경우를 말한다.
        //effective final인 경우는 로컬클래스,익명클래스, 람다표현식 셋 다 참조가능하다.
        //final int baseNumber = 10 이렇게 써야하는데 자바 8부터는 final 생략가능하다.
        //baseNumber 이 변수가 사실상 final인 경우엔 생략가능하다.
        //final int baseNumber = 10; baseNumber++ 적으면 에러난다.
        int baseNumber = 10;

        //로컬클래스, 익명클래스와 람다의 차이점: 쉐도잉
        //쉐도잉 : 예를들어 클래스에 name라는 변수를 쓰고, 클래스 안의 메서드에도 name라는 변수를 쓰면 메서드 안의 name 변수로인해 클래스의 변수인 name이 가려진다.
        //ex) run() 메서드의 baseNumber=10은 LocalClass 로컬클래스의 baseNumber를 11로 하면 결과는 11이 나온다.
        //이게 로컬클래스와 익명클래스가 똑같이 적용된다. 하지만 람다는 쉐도잉이 적용되지 않는다.
        //람다는 같은 스콥안에 똑같은 변수를 정의할 수 없다. 스콥이란? 해당 클래스나 람다를 감싸고 있는 한단계 위의 메서드나 클래스
        //람다 body에 int baseNumber = 10; 똑같이 적으면 에러가 난다.

        //로컬클래스 : 클래스안의 지역클래스라고 보면된다. 보통 메인 클래스에서 해당 클래스를 호출하여 객체를 만들거나, 메서드를 실행한다.
        class LocalClass{
            void printBaseNumber(){
                System.out.println(baseNumber);
            }
            LocalClass printba(){
              return null;
            };
        };

        //익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber);
            }
        };

        //람다표현식에서 localVariable 참조한다.
        IntConsumer printInt = (i) -> {

            System.out.println(i + baseNumber);

        };

        printInt.accept(10);
    }
}
