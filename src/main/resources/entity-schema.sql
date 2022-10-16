
CREATE TABLE guests(
    id SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    invitation_id INT REFERENCES invitations(id)
);