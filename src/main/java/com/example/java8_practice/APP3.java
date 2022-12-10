package com.example.java8_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class APP3 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("keesum");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        //stream()으로 전달받은 names 데이터 자체를 대문자로 바꾼다.
        //stream() 의 종류는 두가지가 있다. 중개오퍼레이션: 스트림 계속해서 이어지는 오퍼레이션, 터미널오퍼레이션 : 종료되는 오퍼레이션
        //두 오퍼레이션의 차이는 중개오퍼레이션은 스트림을 리턴하고 종료오퍼레이션은 스트림이 아닌 다른 타입을 리턴한다.
        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());//종료오퍼레이션

        //중개오퍼레이션은 데이터 return이 안된다. 이 코드 실행해보면 출력이 되지않는다. 터미널 오퍼레이션 오기 전까지 return 없다.
        //종료오퍼레이션이 실행되기 전까지는 중개오퍼레이션은 실행이 안된다. 그냥 정의만 할뿐이다.
        names.stream().map((s) ->{
            System.out.println(s);
            return s.toUpperCase();
        });

        //가장 큰 장점: 손쉽게 병렬처리를 할 수 있다.
        List<String> collect1 = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());//종료오퍼레이션
        //위의 코드를 일반적으로 바꾸면
        for (String name : names) {
            if (name.startsWith("k")){
                System.out.println(name.toUpperCase());
            }//단점: 병렬적으로 처리하기가 힘들다.
        }

        //parallelStream()은 병렬처리이다.
        //parallelStream : 병렬처리이기 때문에 순서보장x, 구동되는 스펙에 따라 스레드추가
        //parallel 스트림을 사용하면 코드를 별도의 코어에서 병렬로 실행되는 여러 스트림으로 나눌 수 있으며 최종 결과는 개별 결과의 조합이 된다. 그러나 실행 순서는 우리가 통제 할 수 없다.
        //따라서 실행 순서가 결과에 영향을 주지 않고 한 요소의 상태가 다른 요소에 영향을 주지 않고 소스 데이터도 영향을 받지않는 경우는 병렬 스트림을 사용하는 것이 좋다.
        //한 스레드에서 처리하는 것보다 여러 스레드에서 처리하는 parallel 방식이 더 오래 걸릴 수도있다.
        //parallel이 유용할떄는 데이터가 정말 큰 경우만 유용하다. 그 때 말고는 대부분 stream() 쓴다.
        List<String> collect2 = names.parallelStream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
