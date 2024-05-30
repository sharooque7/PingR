package com.metrics.metric.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")

public class Test {
    public Test() {}

    @PostMapping("/test")
    public void method(){
        System.out.println("Hello Method");
    }

    @PostMapping("/asset")
    public void insert() {

    }
}

