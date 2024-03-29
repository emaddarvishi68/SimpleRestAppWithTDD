package com.emad.tddapp.dao;

import com.emad.tddapp.dao.api.CarRepository;
import com.emad.tddapp.domain.Car;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

@DataJpaTest
/*@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.)*/
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @BeforeEach
    public void addCars(){
        carRepository.save(new Car(1, Car.CarName.PRIUS.name(), Car.CarType.HYBRID.name()));
        carRepository.save(new Car(2, Car.CarName.COROLLA.name(), Car.CarType.NOT_HYBRID.name()));
        carRepository.save(new Car(3, Car.CarName.CAMRY.name(), Car.CarType.NOT_HYBRID.name()));
    }

    @Test
    public void getCarByName_thenReturnCar() {
        Car byName = carRepository.findByName(Car.CarName.PRIUS.name());
        assertNotNull(byName);
        assertEquals(byName.getName(),Car.CarName.PRIUS.name());
    }

}
