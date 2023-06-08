package com.example.mappingDemo.model;

import java.util.Date;
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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="cities")
@SQLDelete(sql = "UPDATE cities SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class cities {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;

	@Column(name = "created_date")
	private Date CreatedDate = new Date();

	@Column(name = "updated_date")
	private Date UpdatedDate ;

	@Column(name = "is_deleted")
	private boolean isDeleted = Boolean.FALSE;
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

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public Date getUpdatedDate() {
		return UpdatedDate=new Date();
	}

	public void setUpdatedDate() {
		UpdatedDate = new Date();
	}


	//	public List<users> getUser() {
//		return user;
//	}
//
//	public void setUser(List<users> user) {
//		this.user = user;
//	}

	
	
}
