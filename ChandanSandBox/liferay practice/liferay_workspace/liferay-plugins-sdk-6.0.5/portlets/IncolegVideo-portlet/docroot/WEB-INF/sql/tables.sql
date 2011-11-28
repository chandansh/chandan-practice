create table video_StoreSettings (
	storeId LONG not null primary key,
	inBId VARCHAR(75) null,
	prBId VARCHAR(75) null,
	outBId VARCHAR(75) null,
	accessKId VARCHAR(75) null,
	secretAKey VARCHAR(75) null
);

create table video_VOMap (
	videoId VARCHAR(75) not null primary key,
	orgId VARCHAR(75) null,
	StoreType VARCHAR(75) null
);

create table video_VideoInfo (
	videoId VARCHAR(75) not null primary key,
	fileName VARCHAR(75) null,
	mappedFileName VARCHAR(75) null,
	fileType VARCHAR(75) null,
	fileSize DOUBLE,
	fileDesc VARCHAR(75) null,
	userEmail VARCHAR(75) null,
	uploadTime DATE null,
	vurl VARCHAR(75) null,
	status INTEGER
);