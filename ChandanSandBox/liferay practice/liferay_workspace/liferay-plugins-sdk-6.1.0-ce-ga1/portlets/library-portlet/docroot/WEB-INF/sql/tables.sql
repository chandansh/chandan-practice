create table LMS_LMSBook (
	uuid_ VARCHAR(75) null,
	bookId LONG not null primary key,
	bookTitle VARCHAR(75) null,
	author VARCHAR(75) null,
	description VARCHAR(75) null,
	fileName VARCHAR(75) null,
	downloaded INTEGER,
	status INTEGER,
	companyId LONG,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	userId LONG,
	userName VARCHAR(75) null
);

create table LMS_LMSBookJoin (
	joinId LONG not null primary key,
	bookId LONG,
	userId LONG,
	bookTitle VARCHAR(75) null,
	author VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	city VARCHAR(75) null,
	zip VARCHAR(75) null,
	emailAddress VARCHAR(75) null
);

create table LMS_MemberAddress (
	userId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	streetAddress1 VARCHAR(75) null,
	streetAddress2 VARCHAR(75) null,
	city VARCHAR(75) null,
	zip VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	mobileNumber VARCHAR(75) null,
	dateAdded DATE null
);