package com.houarizegai.tddcars.service.impl;

import com.houarizegai.tddcars.exception.CarNotFoundException;
import com.houarizegai.tddcars.model.Car;
import com.houarizegai.tddcars.repository.CarRepository;
import com.houarizegai.tddcars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car getCarDetails(String name) {
        return carRepository.findByName(name).orElseThrow(CarNotFoundException::new);
    }
}
