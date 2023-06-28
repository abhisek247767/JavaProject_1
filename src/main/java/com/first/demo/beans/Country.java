package com.first.demo.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="country")

public class Country {
	@Id
	@Column(name="id")
	int id;
	@Column(name="countryName")
	String countryName;
	
	@Column(name="Capital")
	String countryCapital;
	
	public Country(int i, String string, String string2) {
		this.id=i;
		this.countryName=string;
		this.countryCapital=string2;
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}

}
