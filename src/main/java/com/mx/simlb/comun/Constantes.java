package com.mx.simlb.comun;

public class Constantes {

	private static String colorCoral ="#FF4B4B";
	private static String colorEsparrago ="#87A96B";
	private static String colorNaranjaAtomica ="#FFA474";
	private static String colorNegro ="#000000";
	private static String colorBizzardBlue ="#ACE5EE";
	private static String colorAzul = "#1F75FE";
	private static String colorAzulVioleta = "#7366BD";
	private static String colorVerde = "#65FD00";
	private static String colorNaranja = "#FD5D00";
	private static String colorRojo = "#FD0000";
	private static String colorVerdeCoral = "#00FF8D";
	private static String colorAzulCeleste = "#00FFC4";
	private static String colorAzulCielo = "#00ABFF";
	private static String colorAzulMarino = "#0D00FF";
	private static String colorMorado = "#8900FF";
	private static String colorRosa = "#F700FF";
	private static String colorPink = "#FF008D";
	private static String colorCafe = "#894404";
	
	
	public static String elegirColor(int op){
		
		String colorOp="";
		
		switch(op){
			
			case 1:
				colorOp = colorCoral;
				break;
			case 2:
				colorOp = colorEsparrago;
				break;
			case 3:
				colorOp = colorNaranjaAtomica;
				break;
			case 4:
				colorOp = colorNegro;
				break;
			case 5:
				colorOp = colorAzul;
				break;
			case 6:
				colorOp = colorAzulVioleta;
				break;
			case 7:
				colorOp = colorVerde;
				break;
			case 8:
				colorOp = colorNaranja;
				break;
			case 9:
				colorOp = colorRojo;
				break;
			case 10:
				colorOp = colorVerdeCoral;
				break;
			case 11:
				colorOp = colorAzulCeleste;
				break;
			case 12:
				colorOp = colorAzulCielo;
				break;
			case 13:
				colorOp = colorAzulMarino;
				break;
			case 14:
				colorOp = colorMorado;
				break;
			case 15:
				colorOp = colorRosa;
				break;
			case 16:
				colorOp = colorPink;
				break;
			case 17:
				colorOp = colorCafe;
				break;
			case 18:
				colorOp = colorBizzardBlue;
				break;		
		
		}
		
		return colorOp;
	}
	
	
}
