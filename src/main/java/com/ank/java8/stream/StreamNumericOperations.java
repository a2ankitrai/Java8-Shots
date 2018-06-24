package com.ank.java8.stream;

import com.ank.java8.common.Dish;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamNumericOperations {

    public static void main(String[] args) {

        //Mapping to a numeric stream
        int totalCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        System.out.println("totalCalories = " + totalCalories);

        // Converting back to a stream of objects
        IntStream intStream = Dish.menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxedStream = intStream.boxed();

        System.out.println(boxedStream.collect(Collectors.toList()));
        
        // Default values: OptionalInt

        OptionalInt maxCalories = Dish.menu.stream()
                                        .mapToInt(Dish::getCalories)
                                        .max();

        System.out.println("maxCalories = " + maxCalories);
        
        int max = maxCalories.orElse(1);
        System.out.println("max = " + max);

        // Numeric Ranges

        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                    .filter(n -> n % 2 == 0);

        System.out.println("evenNumbersCount = " + evenNumbers.count());

        // Building Streams

        // stream from values
        Stream<String> streamOfStrings = Stream.of("Stream","of","Strings","in","Java 8");
        streamOfStrings.map(String::toUpperCase).forEach(System.out::println);


        // empty stream
        Stream<String> emptyStream = Stream.empty();

        // streams from arrays
        int[] numbers = {2,4,1,6,8,13};

        int sum = Arrays.stream(numbers).sum();

        // Stream from functions: creating infinite streams!

        System.out.println("Streams from Iteration : ");
        Stream.iterate(0, n -> n + 2).limit(5).forEach(System.out::println);

        System.out.println();

        System.out.println("Streams from Generation");
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }
}
