package com.first.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.first.demo.beans.Country;
import com.first.demo.repository.CountryRepository;

@Component
@Service
public class CountryService {
	@Autowired
	CountryRepository countryrep;
	
	public List getAllcountry() {
		 return countryrep.findAll();
		
	}
	public Country getCoutryById(Integer id) {
		return countryrep.findById(id).get();
	}
	public Country getcountryName(String name) {
		List<Country>c=countryrep.findAll();
		Country contry=null;
		for(Country con:c) {
			if(con.getCountryName().equalsIgnoreCase(name));
			contry=con;
		}
		return contry;
	}
	
	public Country addCountry(Country country) {
		country.setId(getmax());
		countryrep.save(country);
		return country;
	}
	public int getmax() {
		return countryrep.findAll().size()+1;
	}
	public Country update(Country c) {
		countryrep.save(c);
		return c;
	}
	public int delete(int id) {
		countryrep.deleteById(id);
		return id;
	}

}
