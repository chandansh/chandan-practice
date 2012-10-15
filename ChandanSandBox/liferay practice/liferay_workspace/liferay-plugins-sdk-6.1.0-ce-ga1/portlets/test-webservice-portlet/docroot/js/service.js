Liferay.Service.register("Liferay.Service.test", "com.test.service", "test-webservice-portlet");

Liferay.Service.registerClass(
	Liferay.Service.test, "Employee",
	{
		create: true,
		update: true,
		findByName: true,
		remove: true
	}
);