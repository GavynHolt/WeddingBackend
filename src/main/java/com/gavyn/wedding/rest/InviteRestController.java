package com.gavyn.wedding.rest;

import com.gavyn.wedding.entity.Guest;
import com.gavyn.wedding.entity.Invitation;
import com.gavyn.wedding.entity.User;
import com.gavyn.wedding.service.RsvpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = { "http://localhost:4200", "https://www.gavynandjacqueline.com" })
public class InviteRestController {

    @Value("${ADMIN_PASSWORD}")
    private String adminPassword;

    @Autowired
    private RsvpService rsvpService;

    Logger logger = LoggerFactory.getLogger(InviteRestController.class);

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {

        logger.info("LOGIN - " + user.getUsername());

        return user.getUsername().equals("admin") && user.getPassword().equals(adminPassword);
    }

    @GetMapping("admin/rsvps")
    public ResponseEntity<List<Guest>> getAllGuestRsvps() {

        logger.info("[ADMIN] get all Guest RSVPs");

        List<Guest> guestRsvps = rsvpService.getAllGuestRsvps();

        return new ResponseEntity<>(guestRsvps, HttpStatus.OK);
    }

    @GetMapping("invitations/{userCode}")
    public ResponseEntity<Invitation> getInvitationByUserCode(@PathVariable(value="userCode") String userCode) {

        Invitation invitation = rsvpService.getInvitationByUserCode(userCode);

        logger.info("get rsvp - " + invitation.toString());

        return new ResponseEntity<>(invitation, HttpStatus.OK);
    }

    @PostMapping("admin/invitations")
    public ResponseEntity<Invitation> addInvitation(@RequestBody Invitation invitationToAdd) {

        Invitation invitation = rsvpService.addInvitation(invitationToAdd);

        logger.info("create rsvp - " + invitationToAdd.toString());

        return new ResponseEntity<>(invitation, HttpStatus.OK);
    }

    @PutMapping("invitations")
    public ResponseEntity<Invitation> updateInvitationRsvps(@RequestBody Invitation invitationToUpdate) {

        rsvpService.updateInvitationRsvps(invitationToUpdate);

        Invitation updatedInvitation = rsvpService.getInvitationByUserCode(invitationToUpdate.getUserCode());

        logger.info("update rsvp - " + invitationToUpdate.toString());

        return new ResponseEntity<Invitation>(updatedInvitation, HttpStatus.OK);
    }

}
