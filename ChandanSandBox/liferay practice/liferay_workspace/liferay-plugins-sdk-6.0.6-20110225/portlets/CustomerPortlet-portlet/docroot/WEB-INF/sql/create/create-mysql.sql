drop database if exists lportal;
create database lportal character set utf8;
use lportal;



create index IX_F1D5C8 on training_Customer (name);
create index IX_A1BDC95C on training_Customer (name, address);


