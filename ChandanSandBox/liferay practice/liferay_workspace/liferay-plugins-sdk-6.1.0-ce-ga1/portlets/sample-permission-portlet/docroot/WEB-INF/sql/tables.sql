create table cks_Address (
	addId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	address VARCHAR(75) null,
	city VARCHAR(75) null,
	state VARCHAR(75) null,
	pin VARCHAR(75) null
);