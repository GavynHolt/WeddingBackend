package com.gavyn.wedding.dao;

import com.gavyn.wedding.entity.Invitation;

import java.util.List;

public interface RsvpDAO {

    public List<Invitation> getAllInvitations();

    public Invitation getInvitationByUserCode(String userCode);

    public void updateInvitationRsvps(Invitation invitationToUpdate);
}
