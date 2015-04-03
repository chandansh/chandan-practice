drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;



create index IX_F1D5C8 on training_Customer (name);
create index IX_A1BDC95C on training_Customer (name, address);



quit