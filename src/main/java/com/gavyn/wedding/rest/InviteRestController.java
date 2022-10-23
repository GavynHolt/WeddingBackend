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
@CrossOrigin(origins = { "http://localhost:4200", "https://gavynandjacqueline.com"})
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

        logger.info("get - " + invitation.toString());

        return new ResponseEntity<Invitation>(invitation, HttpStatus.OK);
    }

    @PutMapping("invitations")
    public ResponseEntity<Invitation> updateInvitationRsvps(@RequestBody Invitation invitationToUpdate) {

        logger.info("update - " + invitationToUpdate.toString());

        rsvpService.updateInvitationRsvps(invitationToUpdate);

        Invitation updatedInvitation = rsvpService.getInvitationByUserCode(invitationToUpdate.getUserCode());

        return new ResponseEntity<Invitation>(updatedInvitation, HttpStatus.OK);
    }

}
