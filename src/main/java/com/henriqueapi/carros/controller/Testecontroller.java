package com.henriqueapi.carros.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Testecontroller {

    @PostMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("OK");
    }

}
