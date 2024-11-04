package com.example.demo.services;

import java.util.List;
import com.example.demo.models.City;

public interface CitiesService {
    List<City> getAllCities();
    City createCity(City city);
    List<City> findCityByName(String name);
}
