package com.example.mappingDemo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cities")
public class cities {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="city")
	//@JoinColumn(name="city_id")
	private List<users> user;
	
	@ManyToOne
	@JoinColumn(name="state_id")
	private states states;

	public cities() {
		super();
	}

	public cities(long id, String name, states state) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public states getStates() {
		return states;
	}

	public void setStates(states states) {
		this.states = states;
	}
	
	
	
//	public List<users> getUser() {
//		return user;
//	}
//
//	public void setUser(List<users> user) {
//		this.user = user;
//	}

	
	
}
