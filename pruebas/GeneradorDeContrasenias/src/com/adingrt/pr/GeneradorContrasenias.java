package com.adingrt.pr;

public class GeneradorContrasenias {
	public static final String CONSONANTES = "bcdfghjklmnpqrstvwxyz";
	public static final String VOCALES = "aeiou";
	public static final String NUMEROS = "0123456789";
	public static final String SIMBOLOS = "~!@#$%^&*()-_=+|\\}]{[:;/?.>,<";
	public static final int NUM_PARES = 3;
	public static final int NUM_NUMS = 2;
	public static final int NUM_SIMB = 1;
	
	public static void main(String[] args) {
		String password = "";
		for (int i = 0; i < NUM_PARES; i++) {
			password += generarPar();
		}
		for (int i = 0; i < NUM_NUMS; i++) {
			password += getAlea(NUMEROS);
		}
		password += getAlea(SIMBOLOS);
		
		System.out.println("El password es: " + password);
	}
	
	private static char getAlea(String opciones) {
		int pos = (int)(Math.random() * opciones.length());
		return opciones.charAt(pos);
	}
	
	private static String generarPar() {
		String par = "";
		par += getAlea(CONSONANTES);
		par += getAlea(VOCALES);
		return par;
	}

}
