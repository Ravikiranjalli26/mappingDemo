package com.example.mappingDemo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mappingDemo.model.cities;
import com.example.mappingDemo.model.states;
import com.example.mappingDemo.model.users;

public interface repository extends JpaRepository<users,Integer> {

}
