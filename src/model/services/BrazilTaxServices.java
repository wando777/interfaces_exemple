package model.services;

public class BrazilTaxServices implements TaxServices{
	
	private static final double BRAZIL_LOWER_TAX = 0.15;
	private static final double BRAZIL_HIGHER_TAX = 0.2;
	
	
	public double taxes(double amount) {
		if (amount <= 100) {
			return amount * BRAZIL_HIGHER_TAX;
		}else {
			return amount * BRAZIL_LOWER_TAX;
		}
		
	}
	
}
