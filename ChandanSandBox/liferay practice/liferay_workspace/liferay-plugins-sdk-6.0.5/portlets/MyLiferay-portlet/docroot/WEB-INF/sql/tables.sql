create table myportlet_coleg_Customer (
	id_ VARCHAR(75) not null primary key,
	name VARCHAR(75) null,
	company VARCHAR(75) null,
	address VARCHAR(75) null
);

create table myportlet_coleg_Employee (
	id_ VARCHAR(75) not null primary key,
	name VARCHAR(75) null,
	address VARCHAR(75) null
);

create table myportlet_coleg_Foo (
	fooId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);