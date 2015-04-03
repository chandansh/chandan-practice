Liferay.Service.register("Liferay.Service.jsontest", "com.test.service", "JsonPortlet-portlet");

Liferay.Service.registerClass(
	Liferay.Service.jsontest, "Student",
	{
		insert: true,
		update: true,
		deleteStudent: true,
		getAllStudent: true
	}
);