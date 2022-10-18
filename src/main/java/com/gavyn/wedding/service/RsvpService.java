package com.gavyn.wedding.service;

import com.gavyn.wedding.entity.Invitation;

import java.util.List;

public interface RsvpService {

    List<Invitation> getAllInvitations();

    public Invitation getInvitationByUserCode(String userCode);

    public void updateInvitationRsvps(Invitation invitationToUpdate);
}
