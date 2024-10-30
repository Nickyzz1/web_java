package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.Palindrome;

@RestController
@RequestMapping("/palindrome")
public class IsPalindrome {

    @SuppressWarnings("unlikely-arg-type")
    @GetMapping("/{word}")
    public Palindrome palindrome(@PathVariable String word, Boolean palindrome) {

        StringBuilder p = new StringBuilder(word).reverse();

        var pal = p.equals(word)? true : false;

        return new Palindrome(p, pal);

    }
    
}
