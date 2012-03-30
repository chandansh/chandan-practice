database sysmaster;
drop database lportal;
create database lportal WITH LOG;

create procedure 'lportal'.isnull(test_string varchar)
returning boolean;
IF test_string IS NULL THEN
	RETURN 't';
ELSE
	RETURN 'f';
END IF
end procedure;




create index IX_F1D5C8 on training_Customer (name);
create index IX_A1BDC95C on training_Customer (name, address);


