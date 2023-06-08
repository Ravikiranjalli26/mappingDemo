package com.example.mappingDemo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mappingDemo.model.users;
import com.example.mappingDemo.Repository.repository;
import org.springframework.stereotype.Service;

@Service
public class Services {

	@Autowired
	private repository repository;
	
	public List<users> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Optional<users> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	public users save(users user) {
		return repository.save(user) ;
	}

	public void delete(Integer id) {
		users u=this.repository.findById(id).get();
		repository.delete(u);
		
	}

}
