package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.dto.CitiesDto;
import com.example.demo.controllers.dto.ProductDTO;
import com.example.demo.models.City;
import com.example.demo.models.Product;
import com.example.demo.services.CitiesService;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = CitiesService.getAllCities();
        return ResponseEntity.ok(cities); // Retorna uma resposta 200 OK com a lista de cidades.
    }

    @GetMapping("/{query}")
    public ResponseEntity<List<City>> get

    
}
