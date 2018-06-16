package com.ank.java8.common;

import lombok.ToString;

@ToString
public enum Color {

   GREEN("GREEN"),
   RED("RED"),
   DARKRED("DARKRED"),
   YELLOW("YELLOW");
    
   String value;
   
   Color(String value) {
       this.value=value;
   }
}
