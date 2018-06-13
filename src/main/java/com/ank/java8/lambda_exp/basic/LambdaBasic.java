package com.ank.java8.lambda_exp.basic;

public class LambdaBasic {

    public static int getLength(String s, StringLength sl) {
	return sl.getLength(s);
    }
    
    public static void main(String[] args) {
	
	System.out.println( getLength("ankit rai", s-> s.length()));
	
    }
    
}
