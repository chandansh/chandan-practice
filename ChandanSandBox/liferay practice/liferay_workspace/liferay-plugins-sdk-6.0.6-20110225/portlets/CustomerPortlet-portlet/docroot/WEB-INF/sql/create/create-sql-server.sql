drop database lportal;
create database lportal;

go

use lportal;



create index IX_F1D5C8 on training_Customer (name);
create index IX_A1BDC95C on training_Customer (name, address);


