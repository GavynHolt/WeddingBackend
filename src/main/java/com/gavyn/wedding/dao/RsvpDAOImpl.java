package com.gavyn.wedding.dao;

import com.gavyn.wedding.entity.Invitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RsvpDAOImpl implements RsvpDAO {

    @Autowired
    private EntityManager entityManager;

    public List<Invitation> getAllInvitations() {

        Query theQuery = entityManager.createQuery("from Invitation");

        List<Invitation> invitations = theQuery.getResultList();

        return invitations;
    }

//    public Invitation getInvitation() {
//
//
//    }
}
