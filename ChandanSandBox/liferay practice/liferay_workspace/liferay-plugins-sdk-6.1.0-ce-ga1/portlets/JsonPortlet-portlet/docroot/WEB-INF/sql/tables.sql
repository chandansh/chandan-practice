create table jsontest_MyStudent (
	id_ LONG not null primary key,
	name VARCHAR(75) null
);

create table jsontest_Student (
	uuid_ VARCHAR(75) null,
	studentId LONG not null primary key,
	name VARCHAR(75) null,
	standard VARCHAR(75) null,
	address VARCHAR(75) null
);