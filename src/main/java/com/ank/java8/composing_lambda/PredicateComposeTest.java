package com.ank.java8.composing_lambda;

import java.util.function.Predicate;

import com.ank.java8.common.Apple;
import com.ank.java8.common.Color;

public class PredicateComposeTest {

    public static boolean appleTest(Apple a, Predicate<Apple> p) {
	return p.test(a);
    }
    
    public static void main(String[] args) {
	
	Predicate<Apple> redApple = a -> a.getColor()==Color.RED;
	
	Predicate<Apple> notRedApple = redApple.negate();
	
	Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight() > 150);
	
	Predicate<Apple> redAndHeavyAppleOrGreen = 
		redApple.and(a -> a.getWeight() > 150)
			.or(a -> a.getColor()==Color.GREEN);
		
	Apple a1 = new Apple(Color.RED, 140);
	  
	System.out.println("Is a1 red Apple: "+ appleTest(a1, redApple));
	System.out.println("Is a1 not red Apple: "+ appleTest(a1, notRedApple));
	System.out.println("Is a1 red And Heavy Apple: "+ appleTest(a1, redAndHeavyApple));
	System.out.println("Is a1 red And Heavy Apple Or Green: "+ appleTest(a1, redAndHeavyAppleOrGreen));
	
	
    }
    
}
