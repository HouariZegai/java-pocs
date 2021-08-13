package com.houarizegai.tddcars.service;

import com.houarizegai.tddcars.exception.CarNotFoundException;
import com.houarizegai.tddcars.model.Car;
import com.houarizegai.tddcars.repository.CarRepository;
import com.houarizegai.tddcars.service.impl.CarServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void getCarDetailsTest() {
        given(carRepository.findByName("pulse")).willReturn(Optional.of(new Car("pulse", "hatchback")));

        Car car = carService.getCarDetails("pulse");
        assertNotNull(car);
        assertEquals("pulse", car.getName());
        assertEquals("hatchback", car.getType());
    }

    @Test
    public void getCarDetailsNotFoundTest() {
        given(carRepository.findByName("pulse")).willThrow(new CarNotFoundException());

        assertThrows(CarNotFoundException.class, () -> carService.getCarDetails("pulse"));
    }
}
