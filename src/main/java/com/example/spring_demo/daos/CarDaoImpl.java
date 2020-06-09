package com.example.spring_demo.daos;

import com.example.spring_demo.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarDaoImpl extends CrudRepository<Car, Integer> {
}
