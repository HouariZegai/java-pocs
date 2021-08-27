package com.example.springcloudstreamskafka.controller;

import com.example.springcloudstreamskafka.entity.PageEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Windowed;
import org.apache.kafka.streams.state.*;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class PageEventController {

    private final StreamBridge streamBridge;
    private final InteractiveQueryService interactiveService;

    /**
     * Send kafka message (event producer)
     * @param topic topic you wanna send to
     * @param name the name to send
     * @return the response entity contains the page event object sent
     */
    @GetMapping("/publish/{topic}/{name}")
    public ResponseEntity<PageEvent> publish(@PathVariable String topic, @PathVariable String name) {
        PageEvent pageEvent = new PageEvent(name, Math.random() > 0.5 ? "U1" : "U2", new Date(),
                new Random().nextInt(8000));
        streamBridge.send(topic, pageEvent);

        return ResponseEntity.ok(pageEvent);
    }

    @GetMapping(path = "/analytics", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<String, Long>> analytics() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> {
                    Map<String, Long> data = new HashMap<>();
                    ReadOnlyWindowStore<String, Long> windowStore = interactiveService
                            .getQueryableStore("page-count", QueryableStoreTypes.windowStore());
                    Instant now = Instant.now();
                    Instant from = now.minusSeconds(5);
                    KeyValueIterator<Windowed<String>, Long> fetchAll = windowStore.fetchAll(from, now);
//                    WindowStoreIterator<Long> fetchAll = windowStore.fetch("P!", from, now); // get only data of the key: P1
                    while(fetchAll.hasNext()) {
                        KeyValue<Windowed<String>, Long> next = fetchAll.next();
                        data.put(next.key.key(), next.value);
                    }

                    return data;
                }).share();
    }
}