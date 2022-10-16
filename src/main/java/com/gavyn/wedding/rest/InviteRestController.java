package com.gavyn.wedding.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://dapper-biscuit-55d875.netlify.app/"})
public class InviteRestController {

    @GetMapping("test")
    public ResponseEntity<String> firstTest() {

        return new ResponseEntity<String>( "This is a new test.", HttpStatus.OK);
    }
}
