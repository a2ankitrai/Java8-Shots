package com.ank.java8.stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamReducingOperations {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        // Summing the elements
        int sum = numbers.stream().reduce(0, (a,b) -> a+b);
        System.out.println("sum = " + sum);
        
        int product = numbers.stream().reduce(1,(a,b) -> a*b);
        System.out.println("product = " + product);

        int sum2 = numbers.stream().reduce(0,Integer::sum);
        System.out.println("sum2 = " + sum2);

        Optional<Integer> optionalNumbersSum = numbers.stream().reduce((a,b) -> a + b);
        System.out.println("optionalNumbersSum = " + optionalNumbersSum);

        List<Integer> emptyList = new ArrayList<>();
        Optional<Integer> optionalEmptyListSum = emptyList.stream().reduce((a,b) -> a + b);
        System.out.println("optionalEmptyListSum = " + optionalEmptyListSum);


        // Maximum and Minimum

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("max = " + max);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("min = " + min);


    }
}
