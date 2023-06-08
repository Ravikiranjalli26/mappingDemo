package com.example.mappingDemo.Controller;

import com.example.mappingDemo.Services.CityServices;
import com.example.mappingDemo.model.cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CitiesController {

    @Autowired
    private CityServices services;

    @GetMapping("cities")
    public List<cities> findAll(){
        return services.findALL();
    }

    @GetMapping("cities/{id}")
    public Optional<cities> findBYId(@PathVariable(value = "id") Integer id){
        return services.findById(id);
    }

    @PostMapping("cities")
    public cities create(@RequestBody cities city){
        return services.create(city);
    }
    @PutMapping("cities/{id}")
    public cities update(@RequestBody cities city,@PathVariable(value = "id") Integer id){
        cities existingCity = services.findById(id).get();
        existingCity.setStates(city.getStates());
        return services.create(city);
    }
    @DeleteMapping("cities/{id}")
    public ResponseEntity<String> Delete(@PathVariable(value = "id") Integer id){
        services.delete(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK) ;
    }
}
