package com.example.mappingDemo.model;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="states")
@SQLDelete(sql = "UPDATE states SET is_deleted = true WHERE id=?")

@Where(clause = "is_deleted=false")
public class states {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String state;
	@Column(name = "created_date")
	private Date CreatedDate = new Date();

	@Column(name = "updated_date")
	private Date UpdatedDate ;

	@Column(name = "is_deleted")
	private boolean isDeleted = Boolean.FALSE;
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

	public void setUpdatedDate(Date updatedDate) {
		this.UpdatedDate = new Date();
	}

	public Date getCreatedDate() {

		return CreatedDate;
	}

	public Date getUpdatedDate() {
		return UpdatedDate;
	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
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

	
	
	
}
