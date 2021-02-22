package com.houarizegai.recordproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author HouariZegai, created on 22/02/2021
 */
public record User(long id, String name, String email) {
}
