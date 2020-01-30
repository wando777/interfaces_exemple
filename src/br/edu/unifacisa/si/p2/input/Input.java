package br.edu.unifacisa.si.p2.input;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Scanner;

public class Input {
	
	private static final Scanner ENTRADA = new Scanner(System.in);
	private static final int PRIMEIRA_LETRA = 0;
	
	public static String leString(String mensagem) {
		System.out.print(mensagem);
		return ENTRADA.nextLine();
	}
	
	public static char leChar(String mensagem) {
		return leString(mensagem).charAt(PRIMEIRA_LETRA);
	}
	
	public static int leInt(String mensagem) {
		return Integer.parseInt(leString(mensagem));
	}
	
	public static long leLong(String mensagem) {
		return Long.parseLong(leString(mensagem));
	}
	
	public static double leDouble(String mensagem) {
		return Double.parseDouble(leString(mensagem));
	}
	
	public static Date leDate(String mensagem) throws ParseException {
		String sDate = leString(mensagem);
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
		return date;	
	}

}
