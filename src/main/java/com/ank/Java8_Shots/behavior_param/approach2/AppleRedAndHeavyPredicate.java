package com.ank.Java8_Shots.behavior_param.approach2;

import com.ank.Java8_Shots.behavior_param.common.Apple;
import com.ank.Java8_Shots.behavior_param.common.Color;

public class AppleRedAndHeavyPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {

	return apple.getColor() == Color.RED && apple.getWeight() > 120;
    }

}
