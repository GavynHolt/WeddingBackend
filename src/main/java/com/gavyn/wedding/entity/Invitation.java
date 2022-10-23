package com.gavyn.wedding.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name="invitations")
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user_code")
    private String userCode;

    @JsonManagedReference
    @OneToMany(mappedBy = "invitation",
        cascade={CascadeType.ALL}
    )
    private List<Guest> guests;

    @Column(name="notes")
    private String notes;

    @Column(name="last_modified")
    private ZonedDateTime lastModified;

    public Invitation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ZonedDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(ZonedDateTime lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Invitation{");
        sb.append("id=").append(id);
        sb.append(", userCode='").append(userCode).append('\'');
        sb.append(", guests=").append(guests);
        sb.append(", notes='").append(notes).append('\'');
        sb.append(", lastModified=").append(lastModified);
        sb.append('}');
        return sb.toString();
    }
}
