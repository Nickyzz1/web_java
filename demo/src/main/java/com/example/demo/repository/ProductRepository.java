package com.example.demo.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.impl.LoginServiceImpl;
import com.example.demo.services.ProductService;

@Configuration
public class ProductRepository {
    // a classe product service impl depende da product repositoty para ter dados do produto, isso é dependencia de uma clase para outra
    // os sprign relaciona as dependencias com beans
    //  @Configuration indica que a classe pode ser usada pelo Spring IoC Container como uma fonte de definições de beans

      @Bean
        public ProductService productService () {
            return new ProductServiceImpl();
        }
}
