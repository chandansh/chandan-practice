create table hr_ShoppingCartExt (
	recId LONG not null primary key,
	cartId LONG,
	itemId LONG,
	amount INTEGER
);

create table hr_ShoppingCategoryExt (
	categoryId LONG not null primary key,
	imageId LONG,
	imageURL VARCHAR(75) null
);