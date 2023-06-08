package com.example.mappingDemo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

@Entity
@Table(name="users")
@SQLDelete(sql = "UPDATE users SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name = "created_date")
	private Date CreatedDate = new Date();

	@Column(name = "updated_date")
	private Date UpdatedDate ;

	@Column(name = "is_deleted")
	private boolean isDeleted = Boolean.FALSE;
	@ManyToOne
	@JoinColumn(name="city_id")
	private cities city;

	private users(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private users() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public cities getCity() {
		return city;
	}

	public void setCity(cities cities) {
		this.city = cities;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}


	public Date getUpdatedDate() {
		return UpdatedDate;
	}

	public void setUpdatedDate() {
		UpdatedDate = new Date();
	}


	public void setDeleted(boolean deleted) {
		isDeleted = deleted;
	}
}
