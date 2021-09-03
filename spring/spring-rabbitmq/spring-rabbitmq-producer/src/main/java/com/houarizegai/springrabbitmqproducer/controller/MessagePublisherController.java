package com.houarizegai.springrabbitmqproducer.controller;


import com.houarizegai.springrabbitmqproducer.config.RabbitMQConfig;
import com.houarizegai.springrabbitmqproducer.models.CustomerMessage;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MessagePublisherController {

    private final RabbitTemplate template;

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody CustomerMessage message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());

        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Message published");
    }
}
