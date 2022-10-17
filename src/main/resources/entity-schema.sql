
CREATE TABLE invitations (
    id SERIAL primary key,
    user_code varchar(50)  unique,
    notes text
);

CREATE TABLE guests(
    id SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    invitation_id INT REFERENCES invitations(id),
    rsvp boolean,
    rsvp_ceremony boolean,
    rsvp_reception boolean
);