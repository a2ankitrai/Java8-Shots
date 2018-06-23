package com.ank.java8.stream;

import static com.ank.java8.common.Dish.menu;

import java.util.List;
import java.util.stream.Collectors;

import com.ank.java8.common.Dish;

public class StreamBasicTest {

    public static void main(String[] args) {
	
	List<String> threeHighCaloricDishes = 
		menu.stream()
			.filter(d -> d.getCalories() > 300)
			.map(Dish::getName)
			.limit(3)
			.collect(Collectors.toList());
	
	System.out.println(threeHighCaloricDishes);
    }
}
