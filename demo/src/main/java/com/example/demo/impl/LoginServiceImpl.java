package com.example.demo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.services.LoginService;

public class LoginServiceImpl implements LoginService {

    @Autowired
    // do spring que 
    // request pra banco de dados, dados leves prototype, uma função singleton
    LoginService service;

    @Override
    public Integer login(String username, String password) {

        if(username.equals("admin") && password.equals("batata")) {

            return 1;
        }
        return -1;

    }
    
}
