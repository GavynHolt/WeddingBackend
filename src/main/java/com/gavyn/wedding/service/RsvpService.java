package com.gavyn.wedding.service;

import com.gavyn.wedding.entity.Guest;
import com.gavyn.wedding.entity.Invitation;

import java.util.List;

public interface RsvpService {

    List<Guest> getAllGuestRsvps();

    public Invitation getInvitationByUserCode(String userCode);

    public Invitation addInvitation(Invitation invitationToAdd);

    public void updateInvitationRsvps(Invitation invitationToUpdate);
}
