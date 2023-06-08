package com.example.mappingDemo.Services;

import com.example.mappingDemo.Repository.CitiesRepository;
import com.example.mappingDemo.model.cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CityServices {

    @Autowired
    private CitiesRepository repository;


    public List<cities> findALL() {
        return repository.findAll();
    }

    public Optional<cities> findById(Integer id) {
        return repository.findById(id);
    }

    public cities create(cities city) {
    return repository.save(city);
    }

    public void delete(Integer id) {
        cities deleted =repository.findById(id).get();
     repository.delete(deleted);
    }
}
