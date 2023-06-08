package com.example.mappingDemo.Services;

import com.example.mappingDemo.model.states;
import com.example.mappingDemo.model.users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import com.example.mappingDemo.Repository.StatesRepository;
import org.springframework.stereotype.Service;

@Service
public class Sateservices {

    @Autowired
    private StatesRepository repository;

    public List<states> findAll() {
        return repository.findAll();
    }

    public Optional<states> findById(Integer id) {
        return repository.findById(id);
    }

    public states save(states state) {
        return repository.save(state);
    }

    public void delete(Integer id) {
        states state=repository.findById(id).get();
        repository.delete(state);
    }
}
