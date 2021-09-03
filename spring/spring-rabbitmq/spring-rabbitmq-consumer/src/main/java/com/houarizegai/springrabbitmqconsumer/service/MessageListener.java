package com.houarizegai.springrabbitmqconsumer.service;

import com.houarizegai.springrabbitmqconsumer.config.RabbitMQConfig;
import com.houarizegai.springrabbitmqconsumer.models.CustomerMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void listener(CustomerMessage customerMessage) {
        logger.info(customerMessage.toString());
    }
}
