package com.ank.java8.common;

import java.util.Arrays;
import java.util.List;

public class AppleUtil {

    public static List<Apple> produceApples(){
	List<Apple> appleList = Arrays.asList(new Apple(Color.RED, 80), new Apple(Color.RED, 140),
		new Apple(Color.YELLOW, 125), new Apple(Color.GREEN, 80), new Apple(Color.GREEN, 80),
		new Apple(Color.DARKRED, 80));
	return appleList;
	
    }
    
    public static List<Apple> produceApplesV2(){
	List<Apple> appleList = Arrays.asList(
		new Apple(Color.RED, 95), 
		new Apple(Color.RED, 140),
		new Apple(Color.YELLOW, 125), 
		new Apple(Color.GREEN, 60), 
		new Apple(Color.GREEN, 140),
		new Apple(Color.DARKRED, 169));
	return appleList;
	
    }
}
