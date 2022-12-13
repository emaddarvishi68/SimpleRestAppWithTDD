package com.emad.tddapp.dao.impl;

import com.emad.tddapp.dao.api.CarRepository;
import com.emad.tddapp.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CarRepositoryImpl implements CarRepository {

    @Override
    public Car findByName(String carName) {
        return new Car(1, Car.CarName.PRIUS.name(), Car.CarType.HYBRID.name());
    }
}
