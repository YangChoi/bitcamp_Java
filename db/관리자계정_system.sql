create user c##java identified by bit;
grant create session, create table, create sequence, create view to c##java;
alter user c##java default tablespace users;
alter user c##java quota unlimited on users;

select * from all_users;

drop user c##java;

