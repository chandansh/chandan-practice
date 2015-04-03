create table training_Customer (
	id_ decimal(20,0) not null primary key  identity(1,1),
	name varchar(75) null,
	address varchar(75) null,
	inductionDate datetime null
)
go
