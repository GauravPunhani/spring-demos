package com.example.clientservice.controller;

import com.example.clientservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public String getService(@RequestParam String code, @RequestParam String lang){
        Locale locale = new Locale(lang);
        return messageService.getMessage(code, locale);
    }
}
