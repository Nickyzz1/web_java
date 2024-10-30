package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.JImaexp;

@RestController
@RequestMapping("/ImaginaryExponential")
public class Imaexp {

    @GetMapping("/{a}/{b}")
    public JImaexp imagExp(@PathVariable Double a, @PathVariable Double b) {

        Double re = a * Math.sin(b);
        Double im = a * Math.cos(b);

        return new JImaexp(re, im);

    }
    
}
