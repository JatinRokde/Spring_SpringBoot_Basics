package com.jr.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
// Default scope is the singleton scope
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling daily for 15 minutes!!";
    }
}
