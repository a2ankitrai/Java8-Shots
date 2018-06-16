package com.ank.java8.behavior_param.approach1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ank.java8.common.Apple;
import com.ank.java8.common.AppleUtil;
import com.ank.java8.common.Color;

public class AppleFilterTestJava7 {

    /**
     * Approach 1 Will have to duplicate the code for red apple .. DRY fail!!
     * 
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApple(List<Apple> inventory) {
	List<Apple> result = new ArrayList<>();
	for (Apple apple : inventory) {
	    if (apple.getColor() == Color.GREEN) {
		result.add(apple);
	    }
	}
	return result;
    }

    /**
     * Approach 2 Passing color parameter. Better than previous but still a fail if
     * a new criterion to be added for filter.
     * 
     */
    public static List<Apple> filterAppleByColor(List<Apple> inventory, Color color) {
	List<Apple> result = new ArrayList<>();
	for (Apple apple : inventory) {
	    if (apple.getColor() == color) {
		result.add(apple);
	    }
	}
	return result;
    }

    public static void main(String[] args) {

	List<Apple> appleList = AppleUtil.produceApples();

	List<Apple> result1 = AppleFilterTestJava7.filterGreenApple(appleList);

	System.out.println(result1);

	List<Apple> result2 = AppleFilterTestJava7.filterAppleByColor(appleList, Color.RED);

	System.out.println(result2);

    }
}
