package com.example.internationlization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {
    @Autowired
    MessageSource messageSource;
    public String getMessage(String code, Locale locale) {
        return messageSource.getMessage(code,null,locale);
    }
}
