package com.ank.java8.lambda_exp;

public class ExecuteAroundTest {

    public static void printVariation(String s, OntheFlyPrint p) {

	System.out.println(p.printThis(s));
    }

    public static void main(String[] args) {

	String s = "Original_String";

	printVariation(s, (p) -> p); // normal print

	printVariation(s, (p) -> p.toUpperCase()); // UpperCase Print

	printVariation(s, (p) -> p.toLowerCase()); // UpperCase Print

    }
}

@FunctionalInterface
interface OntheFlyPrint {

    String printThis(String s);
}
