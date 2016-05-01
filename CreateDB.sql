create database ACCOUNTING with encoding='UTF8' CONNECTION LIMIT = -1;
create user dbuser with password 'ConfigPasswordForAccounting1';
grant all privileges on database ACCOUNTING to dbuser;


--Create Role table
--CREATE SEQUENCE ROLE_IDS; analog autoincrement
CREATE TABLE roles (ID SERIAL PRIMARY KEY, NAME CHAR(64));

INSERT INTO roles (NAME) VALUES ('ADMIN');
INSERT INTO roles (NAME) VALUES ('USER');


GRANT ALL ON TABLE roles TO public;


--Create PersonalInformations table
CREATE TABLE IF NOT EXISTS PERSONALINFORMATIONS (
  ID SERIAL PRIMARY KEY,
  FIRSTNAME varchar(100) NOT NULL,
  SECONDNAME varchar(100) NOT NULL,
  LASTNAME varchar(100) NOT NULL,
  BIRTHDAY date NOT NULL
);

GRANT ALL ON TABLE PERSONALINFORMATIONS TO public;


insert into PERSONALINFORMATIONS values (1,'user','user','user','01-02-2010'); 
--Create Users table


CREATE TABLE IF NOT EXISTS USERS (
  ID SERIAL PRIMARY KEY,
  LOGIN varchar(50) NOT NULL,
  PASSWORD varchar(60) NOT NULL,
  EMAIL varchar(100) NOT NULL,
  ROLEID integer REFERENCES ROLES,
  PERSONALINFORMATIONID integer REFERENCES PERSONALINFORMATIONS  
   
);

GRANT ALL ON TABLE users TO public;
GRANT USAGE, SELECT ON SEQUENCE users_id_seq TO public;
GRANT USAGE, SELECT ON SEQUENCE personalinformations_id_seq TO public;
insert into users(login,email,password,roleid,personalinformationid) values('user','user@user.com','user',1,2);

 select currval('users_id_seq');

--Djava.library.path=c:\dev\tomcat\bin




