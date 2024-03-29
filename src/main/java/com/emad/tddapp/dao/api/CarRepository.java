package com.emad.tddapp.dao.api;

import com.emad.tddapp.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    @Query(value = "select c from Car c where c.name = :carName")
    Car findByName(String carName);

}
