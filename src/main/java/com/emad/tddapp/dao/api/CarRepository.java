package com.emad.tddapp.dao.api;

import com.emad.tddapp.domain.Car;

public interface CarRepository {

    Car findByName(String carName);

}
