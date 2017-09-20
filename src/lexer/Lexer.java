package lexer;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Lexer {
	
	static final int SUMAR = 0;
	static final int RESTAR = 1;
	static final int ASIGNAR = 2;
	static final int ENTERO = 3;
	static final int LETRAS = 4;
	static final int IMPRIMIR = 5;
	static final int ERROR = 6;
	private String textString;
	private String evalString;
	private int strPos;
	private ArrayList<String> tokens;
	private ArrayList<String> palabras;
	private ArrayList<String> evalTokens;	
	
	public Lexer() {
		strPos = 0;
		tokens = new ArrayList<String>();
		evalTokens = new ArrayList<String>();
		palabras = new ArrayList<String>();
		tokens.add("SUMAR");
		tokens.add("RESTAR");
		tokens.add("ASIGNAR");
		tokens.add("ENTERO");
		tokens.add("LETRAS");
		tokens.add("IMPRIMIR");
		tokens.add("ERROR");
	}
	
	public void evaluar(String archivoTexto) {
		
		try {
			textString = new String(Files.readAllBytes(Paths.get(archivoTexto)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		palabras = new ArrayList<String>((Arrays.asList(textString.split("\\r+\\n+|\\t+|\\s+"))));
		System.out.println(palabras.toString());
		
		for(String s : palabras) {
			evalString = s;
			evalTokens.add(tokens.get(estado_0()));
			strPos = 0;
		}
		
		System.out.println(evalTokens.toString());
		
	}
	
	private char obtenerCaracter() {
		char c = evalString.charAt(strPos);
		strPos++;
		return c;
	}
	
	private int estado_0(){
		if(strPos>=evalString.length()) {
			return ERROR;
		}
		char c = obtenerCaracter();
		
		switch(c) {
			case '+': return estado_1();
			case '-': return estado_2();
			case '=': return estado_3();
			case '0': return ERROR;
			case 'p': return estado_8();
			case 'r': return estado_6();
			case 'i': return estado_6();
			case 'n': return estado_6();
			case 't': return estado_6();
			default:
				if(c>=48 && c<=57) {
					return estado_4();
				}
				if((c>=65 && c<=90)||(c>=97 && c<=122)) {
					return estado_6();
				}	
		}
		return ERROR;
	}
	
	private int estado_1(){
		return SUMAR;
	}
	
	private int estado_2(){
		return RESTAR;
	}
	
	private int estado_3(){
		return ASIGNAR;
	}
	
	private int estado_4(){
		if(strPos>=evalString.length()) {
			return estado_5();
		}
		char c = obtenerCaracter();
		
		switch(c) {
			case '+': return estado_5();
			case '-': return estado_5();
			case '=': return estado_5();
			case '0': return estado_4();
			case 'p': return estado_8();
			case 'r': return estado_5();
			case 'i': return estado_5();
			case 'n': return estado_5();
			case 't': return estado_5();
			default:
				if(c>=48 && c<=57) {
					return estado_4();
				}
				if((c>=65 && c<=90)||(c>=97 && c<=122)) {
					return estado_5();
				}
		}
		return ERROR;
	}
	
	private int estado_5(){
		return ENTERO;
	}
	
	private int estado_6(){
		if(strPos>=evalString.length()) {
			return estado_7();
		}
		char c = obtenerCaracter();
		
		switch(c) {
			case '+': return estado_7();
			case '-': return estado_7();
			case '=': return estado_7();
			case '0': return estado_7();
			case 'p': return estado_6();
			case 'r': return estado_6();
			case 'i': return estado_6();
			case 'n': return estado_6();
			case 't': return estado_6();
			default:
				if(c>=48 && c<=57) {
					return estado_7();
				}
				if((c>=65 && c<=90)||(c>=97 && c<=122)) {
					return estado_6();
				}			
		}
		return ERROR;
	}
	
	private int estado_7(){
		return LETRAS;
	}
	
	private int estado_8(){
		if(strPos>=evalString.length()) {
			return estado_7();
		}
		char c = obtenerCaracter();
		
		switch(c) {
			case '+': return estado_7();
			case '-': return estado_7();
			case '=': return estado_7();
			case '0': return estado_7();
			case 'p': return estado_6();
			case 'r': return estado_9();
			case 'i': return estado_6();
			case 'n': return estado_6();
			case 't': return estado_6();
			default:
				if(c>=48 && c<=57) {
					return estado_7();
				}
				if((c>=65 && c<=90)||(c>=97 && c<=122)) {
					return estado_6();
				}	
		}
		return ERROR;
	}
	
	private int estado_9(){
		if(strPos>=evalString.length()) {
			return estado_7();
		}
		char c = obtenerCaracter();
		
		switch(c) {
			case '+': return estado_7();
			case '-': return estado_7();
			case '=': return estado_7();
			case '0': return estado_7();
			case 'p': return estado_6();
			case 'r': return estado_6();
			case 'i': return estado_10();
			case 'n': return estado_6();
			case 't': return estado_6();
			default:
				if(c>=48 && c<=57) {
					return estado_7();
				}
				if((c>=65 && c<=90)||(c>=97 && c<=122)) {
					return estado_6();
				}		
		}
		return ERROR;
	}
	
	private int estado_10(){
		if(strPos>=evalString.length()) {
			return estado_7();
		}
		char c = obtenerCaracter();
		
		switch(c) {
			case '+': return estado_7();
			case '-': return estado_7();
			case '=': return estado_7();
			case '0': return estado_7();
			case 'p': return estado_6();
			case 'r': return estado_6();
			case 'i': return estado_6();
			case 'n': return estado_11();
			case 't': return estado_6();
			default:
				if(c>=48 && c<=57) {
					return estado_7();
				}
				if((c>=65 && c<=90)||(c>=97 && c<=122)) {
					return estado_6();
				}		
		}
		return ERROR;
	}
	
	private int estado_11(){
		if(strPos>=evalString.length()) {
			return estado_7();
		}
		char c = obtenerCaracter();
		
		switch(c) {
			case '+': return estado_7();
			case '-': return estado_7();
			case '=': return estado_7();
			case '0': return estado_7();
			case 'p': return estado_6();
			case 'r': return estado_6();
			case 'i': return estado_6();
			case 'n': return estado_6();
			case 't': return estado_12();
			default:
				if(c>=48 && c<=57) {
					return estado_7();
				}
				if((c>=65 && c<=90)||(c>=97 && c<=122)) {
					return estado_6();
				}			
		}
		return ERROR;
	}
	
	private int estado_12(){
		return IMPRIMIR;
	}

}
