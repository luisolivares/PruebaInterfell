package com.interfell.rest.util;

import java.util.regex.Pattern;

/**
 * Clase encargada de validaciones y métodos utilitarios en el sistema.
 * **/
public class UtilBase {
	
	String emailRegexp = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
	
	public boolean validarEmail(String email){
		
		try {
			Pattern.matches(emailRegexp, email);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR = "+e);
			return false;
		}
		
	}

}
