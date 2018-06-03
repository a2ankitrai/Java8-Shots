package com.ank.Java8_Shots.behavior_param.approach2;

import com.ank.Java8_Shots.behavior_param.common.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
	return apple.getWeight() > 120;
    }

}
