create index IX_7896CF6B on LMS_LMSBook (bookTitle);
create index IX_C0139640 on LMS_LMSBook (uuid_);
create unique index IX_6276E66A on LMS_LMSBook (uuid_, groupId);