package com.emad.tddapp.service.impl;

import com.emad.tddapp.dao.api.CarRepository;
import com.emad.tddapp.domain.Car;
import com.emad.tddapp.domain.exceptions.CarNotFoundException;
import com.emad.tddapp.service.api.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car getCarDetails(String carName) {
        Car car = carRepository.findByName(carName);
        if(car == null){
            throw new CarNotFoundException();
        }
        return car;
    }
}
