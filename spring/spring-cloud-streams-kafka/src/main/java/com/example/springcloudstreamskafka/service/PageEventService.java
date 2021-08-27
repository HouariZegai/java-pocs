package com.example.springcloudstreamskafka.service;

import com.example.springcloudstreamskafka.entity.PageEvent;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
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

    @Bean // consume & produce
    public Function<PageEvent, PageEvent> pageEventFunction() {
        return pageEvent -> {
            pageEvent.setName("Name: " + pageEvent.getName());
            pageEvent.setUser("User: " + pageEvent.getUser());
            return pageEvent;
        };
    }

    @Bean
    public Function<KStream<String, PageEvent>, KStream<String, Long>> kStreamFunction() {


        return input -> input.filter((k, v) -> v.getDuration() > 10)
                    .map((k, v) -> new KeyValue<>(v.getName(), 0L))
                    .groupBy((k, v) -> k, Grouped.with(Serdes.String(), Serdes.Long()))
                    .windowedBy(TimeWindows.of(Duration.ofSeconds(5))) // Only data of the last 5 seconds
                    .count(Materialized.as("page-count"))
                    .toStream()
                    .map((k, v) -> new KeyValue<>(String.format("Time: %s - %s => name: %s", k.window().startTime(),
                            k.window().endTime(), k.key()), v));
    }
}
