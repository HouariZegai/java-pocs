package com.houarizegai.tddcars.controller;

import com.houarizegai.tddcars.exception.CarNotFoundException;
import com.houarizegai.tddcars.model.Car;
import com.houarizegai.tddcars.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {CarController.class})
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    void getCarDetailsTest() throws Exception {
        given(carService.getCarDetails(Mockito.anyString()))
                .willReturn(new Car("Scala", "Sedan"));

        mockMvc.perform(get("/cars/Scala"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isMap())
                .andExpect(jsonPath("name").value("Scala"))
                .andExpect(jsonPath("type").value("Sedan"));
    }

    @Test
    public void carNotFoundHttpStatus() throws Exception {
        given(carService.getCarDetails(Mockito.anyString()))
                .willThrow(new CarNotFoundException());

        mockMvc.perform(get("/cars/Scala"))
                .andExpect(status().isNotFound());
    }
}
