create database "repairs_db";

create user "repairs_db_manager" with password '123456';

alter database "repairs_db" owner to "repairs_db_manager";