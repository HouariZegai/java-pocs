package com.houarizegai.springrabbitmqproducer.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CustomerMessage {

    private String messageId;
    private String message;
    private Date messageDate;
}
