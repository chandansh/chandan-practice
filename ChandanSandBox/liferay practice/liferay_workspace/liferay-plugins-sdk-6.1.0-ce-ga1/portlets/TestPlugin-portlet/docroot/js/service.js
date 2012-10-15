Liferay.Service.register("Liferay.Service.test", "com.liferay.test.service", "TestPlugin-portlet");

Liferay.Service.registerClass(
	Liferay.Service.test, "Employee",
	{
		create: true,
		update: true,
		findByName: true,
		remove: true
	}
);