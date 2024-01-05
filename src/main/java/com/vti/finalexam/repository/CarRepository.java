package com.vti.finalexam.repository;

import com.vti.finalexam.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Car.PrimaryKey> {

}
