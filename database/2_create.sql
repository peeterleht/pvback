-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-04-12 10:00:10.498

-- tables
-- Table: company
CREATE TABLE company
(
    id                   serial       NOT NULL,
    subscription_type_id int          NOT NULL,
    name                 varchar(255) NOT NULL,
    logo                 bytea        NULL,
    CONSTRAINT company_pk PRIMARY KEY (id)
);

-- Table: company_user
CREATE TABLE company_user
(
    id               serial  NOT NULL,
    company_id       int     NOT NULL,
    user_id          int     NOT NULL,
    project_role_id  int     NOT NULL,
    is_company_admin boolean NOT NULL,
    CONSTRAINT company_user_pk PRIMARY KEY (id)
);

-- Table: part
CREATE TABLE part
(
    id           serial       NOT NULL,
    name         varchar(255) NOT NULL,
    volume       int          NOT NULL,
    end_deadline date         NOT NULL,
    status       char(1)      NOT NULL,
    CONSTRAINT part_pk PRIMARY KEY (id)
);

-- Table: process_part
CREATE TABLE process_part
(
    id              serial  NOT NULL,
    part_id         int     NOT NULL,
    process_id      int     NOT NULL,
    project_role_id int     NOT NULL,
    project_user_id int     NULL,
    deadline        date    NULL,
    status          char(1) NOT NULL,
    CONSTRAINT process_part_pk PRIMARY KEY (id)
);

-- Table: process
CREATE TABLE process
(
    id              serial       NOT NULL,
    project_id      int          NOT NULL,
    name            varchar(255) NOT NULL,
    description     varchar(255) NOT NULL,
    project_role_id int          NOT NULL,
    status          char(1)      NOT NULL,
    CONSTRAINT process_pk PRIMARY KEY (id)
);

-- Table: project
CREATE TABLE project
(
    id        serial       NOT NULL,
    code      varchar(255) NOT NULL,
    name      varchar(255) NOT NULL,
    client    varchar(255) NOT NULL,
    bank_link varchar(255) NOT NULL,
    status    varchar(255) NOT NULL,
    CONSTRAINT project_pk PRIMARY KEY (id)
);

-- Table: project_role
CREATE TABLE project_role
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT project_role_pk PRIMARY KEY (id)
);

-- Table: project_user
CREATE TABLE project_user
(
    id              serial     NOT NULL,
    user_id         int        NOT NULL,
    project_role_id int        NOT NULL,
    project_id      int        NOT NULL,
    color_rgb       varchar(6) NOT NULL,
    status          char(1)    NOT NULL,
    CONSTRAINT project_user_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role
(
    id   serial      NOT NULL,
    name varchar(30) NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: subscription_type
CREATE TABLE subscription_type
(
    id   serial       NOT NULL,
    tier int          NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT subscription_type_pk PRIMARY KEY (id)
);

-- Table: time_log
CREATE TABLE time_log
(
    id         serial    NOT NULL,
    user_id    int       NOT NULL,
    project_id int       NOT NULL,
    minutes    int       NOT NULL,
    timestamp  timestamp NOT NULL,
    CONSTRAINT time_log_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user"
(
    id       serial       NOT NULL,
    role_id  int          NOT NULL,
    email    varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    name     varchar(255) NOT NULL,
    status   char(1)      NOT NULL,
    CONSTRAINT user_ak_1 UNIQUE (email) NOT DEFERRABLE INITIALLY IMMEDIATE,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: company_subscription_type (table: company)
ALTER TABLE company
    ADD CONSTRAINT company_subscription_type
        FOREIGN KEY (subscription_type_id)
            REFERENCES subscription_type (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: company_user_company (table: company_user)
ALTER TABLE company_user
    ADD CONSTRAINT company_user_company
        FOREIGN KEY (company_id)
            REFERENCES company (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: company_user_project_role (table: company_user)
ALTER TABLE company_user
    ADD CONSTRAINT company_user_project_role
        FOREIGN KEY (project_role_id)
            REFERENCES project_role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: company_user_user (table: company_user)
ALTER TABLE company_user
    ADD CONSTRAINT company_user_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: process_part_part (table: process_part)
ALTER TABLE process_part
    ADD CONSTRAINT process_part_part
        FOREIGN KEY (part_id)
            REFERENCES part (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: process_part_process (table: process_part)
ALTER TABLE process_part
    ADD CONSTRAINT process_part_process
        FOREIGN KEY (process_id)
            REFERENCES process (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;
-- Reference: process_part_process (table: process_part)
ALTER TABLE process_part
    ADD CONSTRAINT process_part_project_role
        FOREIGN KEY (project_role_id)
            REFERENCES project_role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: process_part_project_user (table: process_part)
ALTER TABLE process_part
    ADD CONSTRAINT process_part_project_user
        FOREIGN KEY (project_user_id)
            REFERENCES project_user (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: process_project_role (table: process)
ALTER TABLE process
    ADD CONSTRAINT process_project_role
        FOREIGN KEY (project_role_id)
            REFERENCES project_role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: project_part_project (table: process)
ALTER TABLE process
    ADD CONSTRAINT project_part_project
        FOREIGN KEY (project_id)
            REFERENCES project (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: project_user_project (table: project_user)
ALTER TABLE project_user
    ADD CONSTRAINT project_user_project
        FOREIGN KEY (project_id)
            REFERENCES project (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: project_user_project_role (table: project_user)
ALTER TABLE project_user
    ADD CONSTRAINT project_user_project_role
        FOREIGN KEY (project_role_id)
            REFERENCES project_role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: project_user_user (table: project_user)
ALTER TABLE project_user
    ADD CONSTRAINT project_user_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: time_log_project (table: time_log)
ALTER TABLE time_log
    ADD CONSTRAINT time_log_project
        FOREIGN KEY (project_id)
            REFERENCES project (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: time_log_user (table: time_log)
ALTER TABLE time_log
    ADD CONSTRAINT time_log_user
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user"
    ADD CONSTRAINT user_role
        FOREIGN KEY (role_id)
            REFERENCES role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.

