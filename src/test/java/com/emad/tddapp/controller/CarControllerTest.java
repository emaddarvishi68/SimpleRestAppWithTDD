package com.emad.tddapp.controller;

import com.emad.tddapp.domain.Car;
import com.emad.tddapp.domain.exceptions.CarNotFoundException;
import com.emad.tddapp.service.api.CarService;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getCar_ShouldReturnCar() throws Exception{
        given(carService.getCarDetails(anyString()))
                .willReturn(new Car(1,Car.CarName.PRIUS.name(), Car.CarType.HYBRID.name()));
        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value(Car.CarName.PRIUS.name()))
                .andExpect(jsonPath("type").value(Car.CarType.HYBRID.name()));
    }

    @Test
    public void getCar_returnNotFound() throws Exception{
        given(carService.getCarDetails(anyString())).willThrow(new CarNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
                .andExpect(status().isNotFound());
    }

}
