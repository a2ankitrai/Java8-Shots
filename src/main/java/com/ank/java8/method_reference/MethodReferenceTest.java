package com.ank.java8.method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.ank.java8.common.Apple;
import com.ank.java8.common.Color;

public class MethodReferenceTest {

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
	List<Apple> result = new ArrayList<Apple>();
	for (Integer e : list) {
	    result.add(f.apply(e));
	}
	return result;
    }

    public static void main(String[] args) {

	List<Integer> weights = Arrays.asList(5, 1, 7, 2, 6);
	List<Apple> apples = map(weights, Apple::new);

	System.out.println(apples);
	
	BiFunction<Color, Integer, Apple> bf = Apple :: new;
	
	Apple apple2 = bf.apply(Color.RED, 210);
	
	System.out.println(apple2);
    }
}
