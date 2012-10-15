create table me_Author (
	authorId LONG not null primary key,
	name VARCHAR(75) null,
	specialization VARCHAR(75) null
);

create table me_AuthorPost (
	authorPostId LONG not null primary key,
	postId LONG,
	title VARCHAR(75) null,
	content VARCHAR(75) null,
	authorId LONG,
	name VARCHAR(75) null,
	specialization VARCHAR(75) null
);

create table me_Post (
	postId LONG not null primary key,
	title VARCHAR(75) null,
	content VARCHAR(75) null,
	authorId LONG
);