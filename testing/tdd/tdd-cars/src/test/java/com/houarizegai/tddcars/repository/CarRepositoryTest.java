package com.houarizegai.tddcars.repository;

import com.houarizegai.tddcars.model.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void findByNameTest() {
        Optional<Car> carOptional = carRepository.findByName("duster");
        assertTrue(carOptional.isPresent());
    }

    @Test
    public void findByNameNotFoundTest() {
        Optional<Car> carOptional = carRepository.findByName("pulse");
        assertFalse(carOptional.isPresent());
    }
}
