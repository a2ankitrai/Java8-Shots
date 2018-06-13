package com.ank.java8.behavior_param.approach3;

import java.util.ArrayList;
import java.util.List;

import com.ank.java8.behavior_param.approach2.ApplePredicate;
import com.ank.java8.behavior_param.common.Apple;
import com.ank.java8.behavior_param.common.AppleUtil;
import com.ank.java8.behavior_param.common.Color;

public class AppleFilterTestApproach3 {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
	List<Apple> result = new ArrayList<>();

	for (Apple apple : inventory) {
	    if (predicate.test(apple)) {
		result.add(apple);
	    }
	}
	return result;
    }

    public static void main(String[] args) {

	List<Apple> list = AppleUtil.produceApples();

	// Passing behavior in-line. Lambdas in Action!
	List<Apple> greenApples = filterApples(list, (apple) -> apple.getColor() == Color.GREEN);
	
	List<Apple> heavyApples = filterApples(list, (apple) -> apple.getWeight() > 120);
	

	System.out.println("Green Apples:" + greenApples);
	
	System.out.println("Heavy Apples:" + heavyApples);
    }
}
