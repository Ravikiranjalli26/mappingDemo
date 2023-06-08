package com.example.mappingDemo.Controller;

import com.example.mappingDemo.model.states;
import com.example.mappingDemo.model.states;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.mappingDemo.Services.Sateservices;

import java.util.List;
import java.util.Optional;

@RestController
public class StatesController {

    @Autowired
    private Sateservices services;

    @GetMapping("states")
    public List<states> getAll(){
        return services.findAll() ;

    }

    @GetMapping("states/{id}")
    public Optional<states> getById(@PathVariable(value="id") Integer id ){
        return services.findById(id);

    }

    @PostMapping("states")
    public states save(@Validated @RequestBody states state) {
        return services.save(state);
    }

    @PutMapping("states/{id}")
    public ResponseEntity<states> update(@PathVariable(value="id") Integer id, @Validated @RequestBody states state) {
        states updatstate= this.services.findById(id).get();
        updatstate.setState(state.getState());
        services.save(updatstate);
        return new ResponseEntity<>(updatstate, HttpStatus.OK);
    }

    @DeleteMapping("states/{id}")
    public ResponseEntity<String> delete(@PathVariable(value="id") Integer id ) {
        services.delete(id);

        return new ResponseEntity<>("User deleted",HttpStatus.OK) ;

    }
}
