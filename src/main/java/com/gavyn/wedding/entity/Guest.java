package com.gavyn.wedding.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="rsvp")
    private Boolean rsvp;

    @Column(name="rsvp_ceremony")
    private Boolean rsvpCeremony;

    @Column(name="rsvp_reception")
    private Boolean rsvpReception;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "invitation_id")
    private Invitation invitation;

    public Guest() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getRsvp() {
        return rsvp;
    }

    public void setRsvp(Boolean rsvp) {
        this.rsvp = rsvp;
    }

    public Boolean getRsvpCeremony() {
        return rsvpCeremony;
    }

    public void setRsvpCeremony(Boolean rsvpCeremony) {
        this.rsvpCeremony = rsvpCeremony;
    }

    public Boolean getRsvpReception() {
        return rsvpReception;
    }

    public void setRsvpReception(Boolean rsvpReception) {
        this.rsvpReception = rsvpReception;
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Guest{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", rsvp=").append(rsvp);
        sb.append(", rsvpCeremony=").append(rsvpCeremony);
        sb.append(", rsvpReception=").append(rsvpReception);
        sb.append('}');
        return sb.toString();
    }
}
