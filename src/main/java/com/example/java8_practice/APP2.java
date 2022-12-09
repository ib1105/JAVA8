package com.example.java8_practice;

import java.util.ArrayList;
import java.util.List;

public class APP2 {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesum");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        //스태틱메소드 종류에 대하여 알아보자

        //s는 인자
       name.forEach((s) -> {
            System.out.println(s);
       });

       //윗 코드와 똑같다.
        for (String n : name) {
            System.out.println(n);
        }


    }
}
