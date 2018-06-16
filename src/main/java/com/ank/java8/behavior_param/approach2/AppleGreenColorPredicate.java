package com.ank.java8.behavior_param.approach2;

import com.ank.java8.common.Apple;
import com.ank.java8.common.Color;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
	return apple.getColor() == Color.GREEN;
    }

}
