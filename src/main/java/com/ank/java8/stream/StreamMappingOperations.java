package com.ank.java8.stream;

import com.ank.java8.common.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.ank.java8.common.Dish.menu;

public class StreamMappingOperations {

    public static void main(String[] args) {

        // Applying a function to each element of a stream
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println("dishNames = " + dishNames);

        List<Integer> dishNamelengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println("dishNamelengths = " + dishNamelengths);

        //Flattening streams
        String[] arrayOfWords = {"Goodbye", "World"};

        List<String> uniqueCharacters = Arrays.stream(arrayOfWords)
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("uniqueCharacters = " + uniqueCharacters);


    }
}
