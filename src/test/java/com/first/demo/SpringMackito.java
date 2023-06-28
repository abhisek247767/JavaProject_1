package com.first.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.demo.beans.Country;
import com.first.demo.repository.CountryRepository;
import com.first.demo.services.CountryService;

@SpringBootTest(classes= {SpringMackito.class})

public class SpringMackito {
	@Mock
	CountryRepository countryrep;
	@InjectMocks
	CountryService countryservice;
	public List<Country>mycountries;
	@Test
	@Order(1)
	public void test_getAllcountries() {
		List<Country>mycountries=new ArrayList<>();
		mycountries.add(new Country(100,"srilanka","Colombo"));
		mycountries.add(new Country(101,"maldip","male"));
		when(countryrep.findAll()).thenReturn(mycountries);
		assertEquals(102,countryservice.getAllcountry());
		

	}
	
	
	
	
}
