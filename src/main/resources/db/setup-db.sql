create database blogdb;

create user 'blog'@'localhost' identified by 'blog12';
grant all privileges on blogdb.* to 'blog'@'localhost';
flush privileges;