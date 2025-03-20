package com.example.service2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class Service1 {
    @GetMapping
    @ResponseBody
    public String getService(){
        return "service1";
    }
}
