package com.gavyn.wedding.dao;

import com.gavyn.wedding.entity.Guest;
import com.gavyn.wedding.entity.Invitation;

import java.util.List;

public interface RsvpDAO {

    public List<Guest> getAllGuestRsvps();

    public Invitation getInvitationByUserCode(String userCode);

    public Invitation addInvitation(Invitation invitationToAdd);

    public void updateInvitationRsvps(Invitation invitationToUpdate);
}
