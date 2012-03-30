create table training_Customer (
	id_ bigint not null primary key  identity(1,1),
	name nvarchar(75) null,
	address nvarchar(75) null,
	inductionDate datetime null
);
