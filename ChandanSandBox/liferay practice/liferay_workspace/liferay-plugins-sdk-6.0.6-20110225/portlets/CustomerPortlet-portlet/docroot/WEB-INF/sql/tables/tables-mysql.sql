create table training_Customer (
	id_ bigint not null primary key  auto_increment,
	name varchar(75) null,
	address varchar(75) null,
	inductionDate datetime null
) engine InnoDB;
