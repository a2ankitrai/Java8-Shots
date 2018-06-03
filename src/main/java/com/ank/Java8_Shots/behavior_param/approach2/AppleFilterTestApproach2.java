package com.ank.Java8_Shots.behavior_param.approach2;

import java.util.ArrayList;
import java.util.List;

import com.ank.Java8_Shots.behavior_param.common.Apple;
import com.ank.Java8_Shots.behavior_param.common.AppleUtil;

public class AppleFilterTestApproach2 {

    
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate){
	List<Apple> result = new ArrayList<>();
	
	for(Apple apple : inventory) {
	    if(predicate.test(apple)) {
		result.add(apple);
	    }
	}
	return result;
    }
    public static void main(String[] args) {
	
	List<Apple> list = AppleUtil.produceApples();
	
	List<Apple> redAndHeavyApples = filterApples(list, new AppleRedAndHeavyPredicate());
	
	System.out.println(redAndHeavyApples);
    }
}