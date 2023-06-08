package com.example.mappingDemo.Repository;

import com.example.mappingDemo.model.states;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatesRepository extends JpaRepository<states,Integer> {
}
