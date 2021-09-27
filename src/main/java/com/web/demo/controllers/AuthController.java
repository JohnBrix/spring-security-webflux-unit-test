package com.web.demo.controllers;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("home")
public class AuthController {

    @GetMapping("user")
    @PreAuthorize("hasRole('USER')")
    public Mono<String> userHome(){
        return Mono.just("user home");
    }

    @GetMapping("admin")
    @PreAuthorize("hasRole('ADMIN')")
    public Mono<String> adminHome(){
        return Mono.just("admin home");
    }

    @GetMapping("any")
    public Mono<String> any(){
        return Mono.just("authenticated home");
    }

    @GetMapping("/hello")
    public Mono<ResponseEntity<String>> hello(){

        log.info(" AIGFDA");
        return Mono.just(new ResponseEntity<>("working", HttpStatus.CREATED));
    }

}