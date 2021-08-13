package com.houarizegai.tddcars.cache;

import com.houarizegai.tddcars.model.Car;
import com.houarizegai.tddcars.repository.CarRepository;
import com.houarizegai.tddcars.service.CarService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;

@SpringBootTest
public class CacheTest {

    @MockBean
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @Test
    public void cacheTest() {
        given(carRepository.findByName("pulse")).willReturn(Optional.of(new Car("pulse", "hatchback")));

        Car car = carService.getCarDetails("pulse");
        assertNotNull(car);
        carService.getCarDetails("pulse");

        Mockito.verify(carRepository, times(1)).findByName("pulse");
    }
}
