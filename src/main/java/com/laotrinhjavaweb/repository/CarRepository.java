package com.laotrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laotrinhjavaweb.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
