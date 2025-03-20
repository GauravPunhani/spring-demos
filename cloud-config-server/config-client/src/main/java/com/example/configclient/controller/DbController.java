package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("dbname")
public class DbController {
    @Value("${db.name}")
    private String dbname;

    @GetMapping
    public String getDbName(){
        return dbname;
    }
}
