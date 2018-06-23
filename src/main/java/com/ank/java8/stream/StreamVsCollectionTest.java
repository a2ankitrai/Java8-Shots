package com.ank.java8.stream;

import com.ank.java8.common.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamVsCollectionTest {

    public static void main(String[] args) {

        List<String> title  = Arrays.asList("Java","is","sucking","my","soul");
        Stream<String> s = title.stream();
       // s.forEach(System.out::println);
        //s.forEach(System.out::println); //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

        System.out.println(title);


        List<String> names  = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(names);
    }
}
