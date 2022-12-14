package com.gavyn.wedding.service;

import com.gavyn.wedding.dao.RsvpDAO;
import com.gavyn.wedding.entity.Guest;
import com.gavyn.wedding.entity.Invitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RsvpServiceImpl implements RsvpService {

    @Autowired
    private RsvpDAO rsvpDAO;

    @Override
    @Transactional
    public List<Guest> getAllGuestRsvps() {
        return rsvpDAO.getAllGuestRsvps();
    }

    @Override
    @Transactional
    public Invitation getInvitationByUserCode(String userCode) {

        return this.rsvpDAO.getInvitationByUserCode(userCode);
    }

    @Override
    @Transactional
    public Invitation addInvitation(Invitation invitationToAdd) {
        return this.rsvpDAO.addInvitation(invitationToAdd);
    }

    @Override
    @Transactional
    public void updateInvitationRsvps(Invitation invitationToUpdate) {

        this.rsvpDAO.updateInvitationRsvps(invitationToUpdate);
    }
}
