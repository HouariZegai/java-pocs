package com.houarizegai.tddcars.controller;

import com.houarizegai.tddcars.model.Car;
import com.houarizegai.tddcars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/{name}")
    public ResponseEntity<Car> getCar(@PathVariable String name) {
        Car car = carService.getCarDetails(name);
        return ResponseEntity.ok(car);
    }
}
