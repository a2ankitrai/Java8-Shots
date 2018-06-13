package com.ank.java8.lambda_exp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
	List<T> results = new ArrayList<T>();

	for (T s : list) {
	    if (p.test(s)) {
		results.add(s);
	    }
	}
	return results;
    }

    public static void main(String[] args) {

	List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

	System.out.println(filter(integerList, (i) -> i % 2 == 0)); // Even numbers

	List<String> stringList = Arrays.asList("Alpha", "Tango", "Armageddon", "Augmented", "Krypton", "Latin");

	System.out.println(filter(stringList, (s) -> s.startsWith("A"))); // Strings starting with A
    }

}
