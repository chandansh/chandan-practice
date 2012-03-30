create table training_Customer (
	id_ bigint not null primary key generated always as identity,
	name varchar(75),
	address varchar(75),
	inductionDate timestamp
);
