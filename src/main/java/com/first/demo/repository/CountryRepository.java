package com.first.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.demo.beans.Country;

public interface CountryRepository extends JpaRepository<Country,Integer> {

}
