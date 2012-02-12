package com.test;

import java.util.ArrayList;
import java.util.TreeSet;

class Car implements Comparable<Car>, Cloneable {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Car c) {
		// if you switch members places
		// you will get ascending order
		return Double.compare(c.getPrice(), price);
	}
}

public class ComparableTreeSetSorting {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		Car car4 = new Car();
		Car car5 = new Car();
		Car car6 = new Car();
		car1.setPrice(55567.95);
		car2.setPrice(10010.33);
		car3.setPrice(22789.46);
		car4.setPrice(55237.95);
		car5.setPrice(32110.33);
		car6.setPrice(25789.46);
		
		

		TreeSet<Car> carsDesc = new TreeSet<Car>();

		carsDesc.add(car1);
		carsDesc.add(car2);
		carsDesc.add(car3);
		carsDesc.add(car4);
		carsDesc.add(car5);
		carsDesc.add(car6);

		System.out.println("Descending order:");
		for (Car c : carsDesc) {
			System.out.println(c.getPrice());
		}
		
		TreeSet<Car> set=(TreeSet<Car>)carsDesc.clone();
		
		System.out.println("Descending order from clone:");
		for (Car c : set) {
			System.out.println(c.getPrice());
		}
		
		carsDesc.remove(car1);
		carsDesc.remove(car2);
		
		System.out.println("after removel Descending order:");
		for (Car c : carsDesc) {
			System.out.println(c.getPrice());
		}
		
		System.out.println(" after removel Descending order from clone:");
		for (Car c : set) {
			System.out.println(c.getPrice());
		}
	
	}
}
