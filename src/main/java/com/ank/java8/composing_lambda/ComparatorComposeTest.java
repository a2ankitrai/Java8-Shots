package com.ank.java8.composing_lambda;

import java.util.Comparator;
import java.util.List;

import com.ank.java8.common.Apple;
import com.ank.java8.common.AppleUtil;

public class ComparatorComposeTest {

    public static void main(String[] args) {
	
	Comparator<Apple> weightComparator = Comparator.comparing(Apple::getWeight);
	
	Comparator<Apple> reverseWeightComparator = weightComparator.reversed();
	
	Comparator<Apple> reverseWeightAndColorComparator = reverseWeightComparator.thenComparing(Apple::getColor);
	
	List<Apple> apples = AppleUtil.produceApplesV2();
	
	apples.sort(weightComparator); 
	System.out.println("Apples Sorted by weight: " + apples);
	
	apples.sort(reverseWeightComparator); 
	System.out.println("Apples Sorted Reverse by weight: " + apples);
	
	apples.sort(reverseWeightAndColorComparator); 
	System.out.println("Apples Sorted Reverse by weight and Color: " + apples);
	
    }
}
