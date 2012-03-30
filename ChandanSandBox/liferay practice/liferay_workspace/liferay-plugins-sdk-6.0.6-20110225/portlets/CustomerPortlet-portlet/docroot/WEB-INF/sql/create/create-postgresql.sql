drop database lportal;
create database lportal encoding = 'UNICODE';
\c lportal;



create index IX_F1D5C8 on training_Customer (name);
create index IX_A1BDC95C on training_Customer (name, address);


