package com.edujini.ws.test;



public class City {
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}

	String name;
	int population;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

}