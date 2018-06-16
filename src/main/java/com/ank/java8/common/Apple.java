package com.ank.java8.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class Apple {

    Color color;
    int weight;
    
    public Apple(int weight) {
	this.weight = weight;
    }
    
    public String toString() {
	return "{Apple : "+this.getColor().toString()+","+this.getWeight()+"}";
    }
}
