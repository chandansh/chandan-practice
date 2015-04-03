create table training_Customer (
	id_ int8 not null primary key,
	name varchar(75),
	address varchar(75),
	inductionDate datetime YEAR TO FRACTION
)
extent size 16 next size 16
lock mode row;
