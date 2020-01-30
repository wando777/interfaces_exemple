package model.entities;

import java.util.Date;

public class CarRental {

	private Date datePickUp;
	private Date dateDrop;

	private Vehicle vehicle;
	private Invoice invoice;

	public CarRental() {
	}

	public CarRental(Date datePickUp, Date dateDrop, Vehicle vehicle) {
		this.datePickUp = datePickUp;
		this.dateDrop = dateDrop;
		this.vehicle = vehicle;
	}

	// Getters & Setters
	public Date getDatePickUp() {
		return datePickUp;
	}

	public void setDatePickUp(Date datePickUp) {
		this.datePickUp = datePickUp;
	}

	public Date getDateDrop() {
		return dateDrop;
	}

	public void setDateDrop(Date dateDrop) {
		this.dateDrop = dateDrop;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
