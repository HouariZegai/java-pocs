package com.example.springcloudstreamskafka.service;

import com.example.springcloudstreamskafka.entity.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class PageEventService {

    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        return input -> System.out.println("PageEvent consumer data: " + input);
    }

    @Bean // Stream poller (used e.g. with sensors to capture data every period and send it)
    public Supplier<PageEvent> pageEventSupplier() {
        return () -> new PageEvent(
                Math.random() > 0.5 ? "P1" : "P2",
                Math.random() > 0.5 ? "U1" : "U2",
                new Date(),
                new Random().nextInt(8000));
    }

    @Bean
    public Function<PageEvent, PageEvent> pageEventFunction() {
        return pageEvent -> {
            pageEvent.setName("Name: " + pageEvent.getName());
            pageEvent.setUser("User: " + pageEvent.getUser());
            return pageEvent;
        };
    }
}
