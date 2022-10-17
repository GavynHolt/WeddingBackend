package com.gavyn.wedding.rest;

import com.gavyn.wedding.entity.Invitation;
import com.gavyn.wedding.service.RsvpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://dapper-biscuit-55d875.netlify.app/"})
public class InviteRestController {

    @Autowired
    private RsvpService rsvpService;

    Logger logger = LoggerFactory.getLogger(InviteRestController.class);

    @GetMapping("invitations")
    public ResponseEntity<List<Invitation>> getAllInvitations(@PathVariable(value="username") String username) {

        logger.info("userCode: " + username);

        List<Invitation> invitations = rsvpService.getAllInvitations();

        return new ResponseEntity<List<Invitation>>( invitations, HttpStatus.OK);
    }

    @GetMapping("invitations/{userCode}")
    public ResponseEntity<Invitation> getInvitationByUserCode(@PathVariable(value="userCode") String userCode) {

        Invitation invitation = rsvpService.getInvitationByUserCode(userCode);

        return new ResponseEntity<Invitation>(invitation, HttpStatus.OK);
    }

}
