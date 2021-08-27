package com.houarizegai.tddcars;

import com.houarizegai.tddcars.model.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void getCarDetailsTest() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Car> response = restTemplate.exchange("http://localhost:" + port + "/cars/duster",
                HttpMethod.GET, entity, Car.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Car car = response.getBody();
        assertNotNull(car);
        assertEquals("hybrid", car.getType());
    }

    @Test
    public void getCarDetailsNotFoundTest() {
        ResponseEntity<Car> response = restTemplate.getForEntity("http://localhost:" + port + "/cars/houari",
                Car.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
