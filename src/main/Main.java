package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.edu.unifacisa.si.p2.input.Input;
//import entities.enums.CarModel;
import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.RentalServices;
import model.services.BrazilTaxServices;

public class Main {

	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		String path = Input.leString("Enter file path: "); // /Users/wandersonherenioaragaoleite/curso-udemy-eclipse-workspace/Udemy_Interfaces/input.txt
		
		System.out.println("Enter rental data:");
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine().trim();
//			int cont = 1;
			
//			while(line != null) {
//				switch(cont) {
//				case 1:
					String carModel = line;
					line = br.readLine().trim();

//				case 2:
					Date pickUpDate = sdf.parse(line);
					line = br.readLine().trim();

//				case 3:
					Date dropDate = sdf.parse(line);
					line = br.readLine().trim();

//				case 4:
					double pricePerHour = Double.parseDouble(line);
					line = br.readLine().trim();

//				case 5:
					double pricePerDay = Double.parseDouble(line);

//				}	
//				cont += 1;
//			}
			CarRental cr = new CarRental(pickUpDate, dropDate, new Vehicle(carModel));
			RentalServices rs = new RentalServices(pricePerHour, pricePerDay, new BrazilTaxServices());
			
			rs.processInvoice(cr);
			
			System.out.println("INVOICE:");
			System.out.println("Basic Pahyment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
			System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
			System.out.println("Total: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));

			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
