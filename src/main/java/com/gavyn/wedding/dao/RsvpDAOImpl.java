package com.gavyn.wedding.dao;

import com.gavyn.wedding.entity.Guest;
import com.gavyn.wedding.entity.Invitation;
import com.gavyn.wedding.rest.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.ZonedDateTime;
import java.util.List;

@Repository
public class RsvpDAOImpl implements RsvpDAO {

    @Autowired
    private EntityManager entityManager;

    public List<Guest> getAllGuestRsvps() {

        TypedQuery<Guest> query = entityManager.createQuery("from Guest", Guest.class);

        return query.getResultList();
    }

    public Invitation getInvitationByUserCode(String userCode) {

        try {
            Query invitationQuery = entityManager.createQuery("from Invitation where user_code=:userCode");
            invitationQuery.setParameter("userCode", userCode);
            Invitation result = (Invitation) invitationQuery.getSingleResult();
            return result;
        } catch (NoResultException nre){
            throw new NotFoundException("No invitation found with the given user code.");
        }
    }

    public Invitation addInvitation(Invitation invitationToAdd) {

        return entityManager.merge(invitationToAdd);
    }

    public void updateInvitationRsvps(Invitation invitationToUpdate) {

        invitationToUpdate.setLastModified(ZonedDateTime.now());

        entityManager.merge(invitationToUpdate);
    }
}
