package com.web.demo.controllers;

import com.web.demo.config.WebSecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest(AuthController.class)
@Import(WebSecurityConfig.class) /*To install context the webflux spring security*/
public class AuthControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void hello() {

        webTestClient
                .get()
                .uri("/home/hello")
                .exchange()
                .expectStatus().isCreated();
    }

}