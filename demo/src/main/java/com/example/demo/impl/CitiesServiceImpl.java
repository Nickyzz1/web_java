package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.City;
import com.example.demo.repositories.CitiesRepository;

@Service
public class CitiesServiceImpl implements CitiesService {

    @Autowired
    private CitiesRepository citiesRepository;

    @Override
    public List<City> getAllCities() {
        return citiesRepository.findAll();
    }

    @Override
    public City createCity(City city) {
        return citiesRepository.save(city);
    }

    @Override
    public List<City> findCityByName(String name) {
        return citiesRepository.findByName(name); // Supondo que você tenha um método findByName no repositório.
    }

    public void createInitialCities() {
        citiesRepository.save(new City("Brazil", "Curitiba", "PR"));
        citiesRepository.save(new City("Japan", "Tokyo", "KT"));
        citiesRepository.save(new City("United States", "New York", "NY"));
        citiesRepository.save(new City("Chéquia", "Praga", "PR"));
    }
}
