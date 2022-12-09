package com.example.java8_practice;

@FunctionalInterface
public interface RunSomething {
    //함수형 인터페이스는 추상메서드가 딱 하나만 있으면된다.
    void doIt();

    static void printName() {
        System.out.println("test");
    }

    default void printAge() {
        System.out.println("40");
    }

    //자바8의 새로운 기능이다. 인터페이스에서 사용할 수 있는 메서드가 다양해졌다. static, default 메서드를 사용할 수 있다.
    //static, default 처럼 다른형태의 메서드가 있더라도 중요하지않다. 중요한건 오로지 추상메서드가 몇개있냐가 중요하다.
    //인터페이스에서는 abstract void doIt(); 인데 abstract 생략할 수 있다. abstract 는 추상메서드이다.
    //이 하나가 무조건 functional 인터페이스고, 정의하려면 @FunctionalInterface 애노테이션을 써준다.
    //@FunctionalInterface 이걸 쓰면 @Override처럼 경고할 수 있어서 써주는게 좋다.(ex. 추상메서드 2개 쓰면 빨간줄)


}
