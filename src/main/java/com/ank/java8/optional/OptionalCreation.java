package com.ank.java8.optional;

import java.util.Optional;

public class OptionalCreation {

	public static void main(String[] args) {

		// Empty optional
		Optional<Car> empOptCar = Optional.empty();

		System.out.println(empOptCar);

		// Optional from a non-null value
		Car car = new Car("Tesla", "Model-S");
		Optional<Car> notNullOptCar = Optional.of(car);
		System.out.println(notNullOptCar);
  		
		// Optional from null
		Car nullCar = null;
		
//		@code{Optional.of} does not support null values. 
//		Optional<Car> notNullOptCar1 = Optional.of(nullCar);
//		System.out.println(notNullOptCar1);
		
		Optional<Car> nullableOptCar2 = Optional.ofNullable(nullCar);
		System.out.println(nullableOptCar2);

	}
}
