package com.gavyn.wedding.service;

import com.gavyn.wedding.dao.RsvpDAO;
import com.gavyn.wedding.entity.Invitation;
import org.springframework.beans.factory.annotation.Autowired;

public class RsvpServiceImpl implements RsvpService {

    @Autowired
    private RsvpDAO rsvpDAO;

//    public Invitation getInvitation() {
//
////        return this.rsvpDAO.getInvitation();
//    }
}
