package com.emad.tddapp.service.impl;

import com.emad.tddapp.dao.api.CarRepository;
import com.emad.tddapp.domain.Car;
import com.emad.tddapp.domain.exceptions.CarNotFoundException;
import com.emad.tddapp.service.api.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@WebMvcTest(CarServiceImpl.class)
public class CarServiceTest {

    @MockBean
    private CarRepository carRepository;
    @Autowired
    private CarService carService;

    @Test
    public void getCarDetails_returnsCarInfo() {
        given(carRepository.findByName(Car.CarName.PRIUS.name()))
                .willReturn(new Car(1,Car.CarName.PRIUS.name(), Car.CarType.HYBRID.name()));
        Car carDetails = carService.getCarDetails(Car.CarName.PRIUS.name());
        assertEquals(Car.CarName.PRIUS.name(), carDetails.getName());
        assertEquals(Car.CarType.HYBRID.name(), carDetails.getType());
    }

    @Test
    public void getCarDetails_whenCarNotFound() throws Exception {
        given(carRepository.findByName(Car.CarName.PRIUS.name())).willThrow(CarNotFoundException.class);
        assertThrows(CarNotFoundException.class, () -> {
            carService.getCarDetails(Car.CarName.PRIUS.name());
        });
    }

}
