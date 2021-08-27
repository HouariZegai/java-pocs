package com.example.springcloudstreamskafka.controller;

import com.example.springcloudstreamskafka.entity.PageEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class PageEventController {

    private final StreamBridge streamBridge;

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
}