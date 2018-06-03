package com.ank.Java8_Shots.behavior_param.common;

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
