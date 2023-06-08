package com.example.mappingDemo.Controller;

import java.util.List;
import java.util.Optional;

import com.example.mappingDemo.Services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mappingDemo.model.users;

@RestController
public class Controller {
	
	@Autowired
	private Services serevices;
	
	@GetMapping("users")
	public List<users> getAll(){
		return serevices.findAll() ;
		
	}
	
	@GetMapping("users/{id}")
	public Optional<users> getById(@PathVariable(value="id") Integer id ){
		return serevices.findById(id);
		
	}

	@PostMapping("users")
	public users save(@Validated @RequestBody users state) {
		return serevices.save(state);
	}
	
	@PutMapping("users/{id}")
	public ResponseEntity<users> update(@PathVariable(value="id") Integer id,@Validated @RequestBody users user) {
		users updatstate= this.serevices.findById(id).get();
		updatstate.setName(user.getName());
		updatstate.setUpdatedDate();
		serevices.save(updatstate);
		return new ResponseEntity<>(updatstate,HttpStatus.OK);
	}
	
	@DeleteMapping("users/{id}")
	public ResponseEntity<String> delete(@PathVariable(value="id") Integer id ) {
		serevices.delete(id);
		return new ResponseEntity<>("User deleted",HttpStatus.OK) ;
		
	}
}
