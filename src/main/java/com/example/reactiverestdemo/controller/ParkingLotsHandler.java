package com.example.reactiverestdemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

@RestController
public class ParkingLotsHandler {

    @GetMapping(path = "parking-lots", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin(origins = "http://locahost:3000")
    public Flux<String> getParkingLotsAvailability() {
        System.out.println("request recieved");
        return Flux.interval(Duration.ofSeconds(5))
                .map(tick -> String.valueOf(new Random().nextInt(10)));
    }

}
