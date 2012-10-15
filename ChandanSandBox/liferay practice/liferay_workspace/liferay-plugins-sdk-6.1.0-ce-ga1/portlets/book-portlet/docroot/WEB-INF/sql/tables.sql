create table Book (
	bookId LONG not null primary key,
	bookNumber LONG,
	writerName VARCHAR(75) null,
	createDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	quantity INTEGER,
	totalCost DOUBLE,
	status VARCHAR(75) null
);

create table ExtWorkFlow (
	extWorkflowId LONG not null primary key,
	resourcePrimKey LONG,
	classNameId LONG,
	classPK LONG,
	parentResourcePrimKey LONG,
	version INTEGER,
	title VARCHAR(75) null,
	content VARCHAR(75) null,
	description VARCHAR(75) null,
	priority INTEGER,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);