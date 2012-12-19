/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.myslayer.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.myslayer.service.http.CarServiceSoap}.
 *
 * @author    Chandan
 * @see       com.myslayer.service.http.CarServiceSoap
 * @generated
 */
public class CarSoap implements Serializable {
	public static CarSoap toSoapModel(Car model) {
		CarSoap soapModel = new CarSoap();

		soapModel.setCarId(model.getCarId());
		soapModel.setBrand(model.getBrand());
		soapModel.setColor(model.getColor());

		return soapModel;
	}

	public static CarSoap[] toSoapModels(Car[] models) {
		CarSoap[] soapModels = new CarSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CarSoap[][] toSoapModels(Car[][] models) {
		CarSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CarSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CarSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CarSoap[] toSoapModels(List<Car> models) {
		List<CarSoap> soapModels = new ArrayList<CarSoap>(models.size());

		for (Car model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CarSoap[soapModels.size()]);
	}

	public CarSoap() {
	}

	public long getPrimaryKey() {
		return _carId;
	}

	public void setPrimaryKey(long pk) {
		setCarId(pk);
	}

	public long getCarId() {
		return _carId;
	}

	public void setCarId(long carId) {
		_carId = carId;
	}

	public String getBrand() {
		return _brand;
	}

	public void setBrand(String brand) {
		_brand = brand;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}

	private long _carId;
	private String _brand;
	private String _color;
}