package com.example.reactive.controller;


import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Locale;

@RestController
@RequestMapping("/reactive-results")
public class ReactiveController {

    @GetMapping
    public Mono<String> getReactiveResults() {
        return Mono.delay(Duration.ofMillis(2000))
                .map(i -> "Response from reactive");
    }
}
