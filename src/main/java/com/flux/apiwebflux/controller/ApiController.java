package com.flux.apiwebflux.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/non_blocking_api")
public class ApiController {


    @GetMapping("/testFlux")
    public Flux<String> testController(){
        return Flux.just("1", " - prueba", " uno").log();
    }

    @GetMapping(value = "/FluxStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> fluxStream(){
        return Flux.just("1", " - prueba", " uno", " dos ", " tres ").delayElements(Duration.ofSeconds(1)).log();
    }

}
