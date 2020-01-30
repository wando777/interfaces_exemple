package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalServices {

	private double pricePerHour;
	private double pricePerDay;

	private static final int MILLISECONDS_TO_HOUR = 1000 * 60 * 60;
	private static final int HALF_DAY = 12;
	private static final int FULL_DAY = 24;

	private TaxServices taxServices;

	public RentalServices() {
	}

	public RentalServices(double pricePerHour, double pricePerDay, TaxServices taxServices) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxServices = taxServices;
	}

	public void processInvoice(CarRental carRental) {
		long time1 = carRental.getDatePickUp().getTime();
		long time2 = carRental.getDateDrop().getTime();
		double hours = (double) (time2 - time1)/MILLISECONDS_TO_HOUR;
		double basicPayment;
		
		if (hours <= HALF_DAY) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		}else {
			basicPayment = Math.ceil(hours/FULL_DAY) * pricePerDay;
		}
		
		double tax = taxServices.taxes(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}

}
