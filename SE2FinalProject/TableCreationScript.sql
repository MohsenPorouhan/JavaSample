create table person(id number(10) not null,firstName varchar2(50),lastName varchar2(50),age number(10),birthDate date,constraint person_pk primary key (id));
create sequence person_sequence minvalue 1 maxvalue 9999999999 start with 1 increment by 1 cache 20;
CREATE TABLE LOGS(USER_ID VARCHAR2(20),DATED DATE NOT NULL,LOGGER VARCHAR2(500) NOT NULL,LEVELL VARCHAR2(100) NOT NULL,MESSAGEE VARCHAR2(1000)  NOT NULL);