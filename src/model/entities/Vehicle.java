package model.entities;

//import entities.enums.CarModel;

public class Vehicle {

	private String model;

	public Vehicle() {
	}

	public Vehicle(String carModel) {
		this.model = carModel;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
