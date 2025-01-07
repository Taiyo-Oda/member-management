--liquibase formatted sql
--changeset nvoxland:1
CREATE TABLE users (
  user_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  user_name VARCHAR(255) NOT NULL,
  mail_address VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  UNIQUE (mail_address)
);
--rollback drop table test1;
