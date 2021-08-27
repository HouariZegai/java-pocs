package com.houarizegai.tddcars.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CAR")
@Getter
@Setter
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
