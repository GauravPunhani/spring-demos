package com.example.exceptiondemo.service;

import com.example.exceptiondemo.exception.ResourceNotFoundException;
import com.example.exceptiondemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserService {

    public User getUser(String id) throws ResourceNotFoundException {
        try{
            //simulate an exception
            int x = 10/0;
            return new User();
        }catch (Exception e){
            throw new ResourceNotFoundException("User not found with id "+ id);
        }
    }
}
