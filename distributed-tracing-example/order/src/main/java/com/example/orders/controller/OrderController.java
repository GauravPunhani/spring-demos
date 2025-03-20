package com.example.orders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
public class OrderController {
    @GetMapping
    @ResponseBody
    public String createOrder() throws InterruptedException {
        Thread.sleep(2000);
        return "Order created";
    }
}
