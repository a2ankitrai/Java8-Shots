package com.ank.java8.stream;

import com.ank.java8.common.Dish;
import static com.ank.java8.common.Dish.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilteringOperations {

    public static void main(String[] args) {

        // Basic Filtering
        List<Dish>  vegetarianMenu = menu.stream()
                                    .filter(Dish::isVegetarian)
                                    .collect(Collectors.toList());
        System.out.println(vegetarianMenu);

        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1,2,1,3,4,6,2,12,8,4);

        numbers.stream()
                .filter(i -> i%2 == 0)
                .distinct()
                .map(i -> i+", ")
                .forEach(System.out::print);

        System.out.println();

        //Truncating a stream
        List<Dish> dishes = menu.stream()
                                .filter(d ->  d.getCalories() > 300)
                                .limit(3)
                .collect(Collectors.toList());

        System.out.println(dishes);

        //Skipping elements
        List<Dish> dishes2 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());

        System.out.println(dishes2);

    }
}
