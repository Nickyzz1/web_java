package com.example.demo.services;

import java.util.List;

import com.example.demo.models.City;

public interface CitiesService {
    List<City> getAllCities();
    City createCity(City city); // criar o objeto produtc no banco de dados precisa de um método que interaja com as classes necessa´rias
    List<City> findCityByName(String name);
}
