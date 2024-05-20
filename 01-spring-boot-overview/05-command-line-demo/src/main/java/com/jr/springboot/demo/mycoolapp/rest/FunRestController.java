package com.jr.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose '/' endpoint that return 'Hello World'

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    // expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "I burnt 5k calories";
    }

    @GetMapping("/greetings")
    public String getGreetings() {
        return "Have a Good Day!";
    }
}
