package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.City;
import com.example.demo.repositories.CitiesRepository;
import com.example.demo.services.CitiesService;

public class CitiesServiceImpl implements CitiesService {

    @Autowired // diz ao código que ele possui dependencias
    private CitiesRepository citiesRepository;

    @Override
    public List<City> getAllCities() {
        // TODO Auto-generated method stub
        return citiesRepository.findAll();
    }

    @Override
    public City createCity(City city) {
        // TODO Auto-generated method stub
        return citiesRepository.findByName(String name);
    }

    @Override
    public List<City> findCityByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCityByName'");
    }

    
}
