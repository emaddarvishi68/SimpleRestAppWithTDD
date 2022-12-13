package com.emad.tddapp.controller;

import com.emad.tddapp.domain.Car;
import com.emad.tddapp.domain.exceptions.CarNotFoundException;
import com.emad.tddapp.service.api.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{carName}")
    public ResponseEntity<Car> getCar(@PathVariable String carName){
        return new ResponseEntity<>(carService.getCarDetails(carName),HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void carNotFoundHandler(CarNotFoundException ex){

    }

}
