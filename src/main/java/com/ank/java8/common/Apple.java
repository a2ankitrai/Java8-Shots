package com.ank.java8.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Apple {

    Color color;
    int weight;
    
    public Apple(int weight) {
	this.weight = weight;
    }
}
