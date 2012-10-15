Liferay.Service.register("Liferay.Service.LMS", "com.library.slayer.service", "library-portlet");

Liferay.Service.registerClass(
	Liferay.Service.LMS, "LMSBook",
	{
		addLibraryBook: true
	}
);