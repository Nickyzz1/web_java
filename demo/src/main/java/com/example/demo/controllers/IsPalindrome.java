package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.Palindrome;

@RestController
@RequestMapping("/palindrome")
public class IsPalindrome {

    @GetMapping("/{word}")
    public Palindrome palindrome(@PathVariable String word, Bollean palindrome) {

        
        var result = word.

        return new Palindrome(word, null)

    }
    
}
