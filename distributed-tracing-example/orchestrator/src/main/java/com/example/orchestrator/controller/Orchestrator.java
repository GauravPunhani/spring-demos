package com.example.orchestrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orchestrators")
public class Orchestrator {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/startOrder")
    @ResponseBody
    public String startOrder(){
        String orderServiceUri = "http://localhost:8081/orders";
        String result = restTemplate.getForObject(orderServiceUri,String.class);
        return "Invoking Order service: " + result;

    }
}
