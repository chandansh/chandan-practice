Liferay.Service.register("Liferay.Service.myslayer", "com.myslayer.service", "SPA-portlet");

Liferay.Service.registerClass(
	Liferay.Service.myslayer, "Car",
	{
		insertCar: true,
		updateCar: true,
		deleteCar: true,
		getAllCars: true
	}
);