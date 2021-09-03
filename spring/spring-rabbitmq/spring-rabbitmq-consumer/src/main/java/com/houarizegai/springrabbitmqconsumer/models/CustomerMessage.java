package com.houarizegai.springrabbitmqconsumer.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
public class CustomerMessage {

    private String messageId;
    private String message;
    private Date messageDate;
}
