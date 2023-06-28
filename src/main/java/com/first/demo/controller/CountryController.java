package com.first.demo.controller;

import com.first.demo.beans.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.first.demo.services.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryservice;

    @GetMapping("/getcountries")
    public List<Country> getAllCountries() {
        return countryservice.getAllcountry();
    }

    @GetMapping("/getcountries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Integer id) {
        Country country = countryservice.getCoutryById(id);
        if (country == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @GetMapping("/name/{countryName}")
    public ResponseEntity<Country> getCountryByName(@PathVariable String countryName) {
        Country country = countryservice.getcountryName(countryName);
        if (country == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(country, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country addedCountry = countryservice.addCountry(country);
        return new ResponseEntity<>(addedCountry, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable (value="id")int id,@RequestBody Country country) {
        Country updatedCountry = countryservice.getCoutryById(id);
        updatedCountry.setCountryName(country.getCountryCapital());
        updatedCountry.setCountryCapital(country.getCountryCapital());
        Country updatedCountry1=countryservice.update(updatedCountry);
        if (updatedCountry1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedCountry1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteCountry(@PathVariable int id) {
        int deletedId = countryservice.delete(id);
        if (deletedId == -1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedId, HttpStatus.OK);
    }
}
