package com.ank.java8.behavior_param.approach2;

import com.ank.java8.common.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
	return apple.getWeight() > 120;
    }

}
