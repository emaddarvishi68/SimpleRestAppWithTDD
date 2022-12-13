package com.emad.tddapp;

import static org.junit.jupiter.api.Assertions.*;

import com.emad.tddapp.domain.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
class IntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void getCar_returnsCarDetails() {
		//arrange

		//act
		ResponseEntity<Car> response = restTemplate.getForEntity("http://localhost:8080/cars/prius",Car.class);

		//assert
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().getName(),Car.CarName.PRIUS.name());
		assertEquals(response.getBody().getType(),Car.CarType.HYBRID.name());
	}

}
