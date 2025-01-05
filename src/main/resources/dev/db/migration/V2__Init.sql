CREATE TABLE Persons
(
    id  int primary key auto_increment,
    create_date datetime default now(),
    update_date timestamp ,
    last_update_date bigint
);