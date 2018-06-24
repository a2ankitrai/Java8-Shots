package com.ank.java8.stream;

import com.ank.java8.common.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFindingMatchingOperations {

    public static void main(String[] args) {

        //anyMatch
        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("This menu contains vegetarian items as well");
        }

        //allMatch
        boolean isHealthy = Dish.menu.stream()
                .allMatch(d -> d.getCalories() < 1000);

        System.out.println("isHealthy = " + isHealthy);
        
        //noneMatch
        boolean isHealthy2 = Dish.menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);

        System.out.println("isHealthy2 = " + isHealthy2);

        //Finding an element : findAny
        Optional<Dish> dish = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        dish.ifPresent(d -> System.out.println(d.getName()));

        //Finding the first element : findFirst
        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                            .map(x -> x*x)
                            .filter(x -> x%3 ==0)
                            .findFirst();

        System.out.println("firstSquareDivisibleByThree = " + firstSquareDivisibleByThree);


    }
}
