package com.example.mappingDemo.Repository;

import com.example.mappingDemo.model.cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<cities,Integer> {


}
