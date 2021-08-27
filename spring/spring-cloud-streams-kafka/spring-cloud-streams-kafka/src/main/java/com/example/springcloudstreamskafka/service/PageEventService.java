package com.example.springcloudstreamskafka.service;

import com.example.springcloudstreamskafka.entity.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class PageEventService {

    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        return input -> {
            System.out.println("PageEvent consumer data: " + input);
        };
    }
}
