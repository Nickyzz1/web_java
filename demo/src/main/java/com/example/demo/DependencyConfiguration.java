package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.impl.LoginServiceImpl;
import com.example.demo.services.LoginService;

@Configuration
public class DependencyConfiguration {

    @Bean
    @Scope("singleton") // request, prototype, singleton(se nn colocar nd é o padrão) (, oq cada um deveria ser, session
    public LoginService loginService() {
        return new LoginServiceImpl();
    }

    @Bean
    @Scope("singleton") // request, prototype, singleton(se nn colocar nd é o padrão) (, oq cada um deveria ser, session
    public LoginService loginService2() {
        return new LoginServiceImpl();}

        //apena sum retorno por interface, nn se coloca o memso serviço para vária smplementações
}

// controlador dependencia nas interfaces , nn nas classes, sempre interface
