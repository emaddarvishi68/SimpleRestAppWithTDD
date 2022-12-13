package com.emad.tddapp.service.api;

import com.emad.tddapp.domain.Car;

import java.util.Optional;

public interface CarService {

    Car getCarDetails(String carName);

}
