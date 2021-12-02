package com.trepudox.music.entrypoint.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/music")
public class MusicController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloMusic() {
        return ResponseEntity.ok("Hello World!");
    }

}
