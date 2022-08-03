package br.com.demo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/demo-exceptions")
@RestController
public class ApiController {

    @GetMapping
    public ResponseEntity<?> handlerException() {

        Integer.parseInt("wyz");

        return ResponseEntity.ok().build();
    }
}
