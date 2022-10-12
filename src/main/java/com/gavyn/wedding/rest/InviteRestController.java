package com.gavyn.wedding.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InviteRestController {

    @GetMapping("test")
    public String firstTest() {
        return "testing 1 2 3";
    }
}
