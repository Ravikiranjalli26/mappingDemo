package com.example.mappingDemo.model;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="states")
public class states {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String state;

	 @OneToMany(cascade = CascadeType.ALL,mappedBy = "states")
	 private List<cities> city = new ArrayList < > ();
	
	
	public states() {
		super();
	}



	public states(long id, String state) {
		super();
		this.id = id;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}


//	public List<cities> getCity() {
//		return city;
//	}
//
//
//
//	public void setCity(List<cities> city) {
//		this.city = city;
//	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}


	
	
	
}
