drop database if exists adlister_db;

create database adlister_db;

use adlister_db;

create table users (
                          id int unsigned not null auto_increment,
                          username varchar(40) not null ,
                          email varchar(40) not null ,
                          password varchar(20) not null,
                          primary key (id),
                          unique (username, email)
);

create table ads (
                     id int unsigned not null auto_increment,
                     users_id int unsigned not null ,
                     title varchar(75) not null ,
                     description varchar(250) not null,
                     primary key (id),
                     foreign key (users_id) REFERENCES users (id)
);

