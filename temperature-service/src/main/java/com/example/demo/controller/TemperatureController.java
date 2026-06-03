package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {
    @GetMapping
    public float getTemperature(@RequestParam(required = true) String location) {
        Random randTemp = new Random();
        return randTemp.nextFloat() * 200 - 100;
    }
}
