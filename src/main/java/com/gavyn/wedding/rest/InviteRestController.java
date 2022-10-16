package com.gavyn.wedding.rest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;


@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://dapper-biscuit-55d875.netlify.app/"})
public class InviteRestController {

    Logger logger = LoggerFactory.getLogger(InviteRestController.class);

    @GetMapping("{username}")
    public ResponseEntity<String> firstTest(@PathVariable(value="username") String username) {

        logger.info("userCode: " + username);

        return new ResponseEntity<String>( "This is a new test.", HttpStatus.OK);
    }
}
