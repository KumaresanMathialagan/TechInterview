package com.kumaresan.restapi.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/sample")
public class SampleRestController {
    @PostMapping("/account/create")
    public ResponseEntity<String> createAccount(
           ) {
        return ResponseEntity.ok("success");
    }
}
