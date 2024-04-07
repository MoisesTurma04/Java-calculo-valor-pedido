package com.ecommerce.mhsecommerce.exceptions;

import java.util.InputMismatchException;

public class ExceptionUtil {

	public static void handleInputMismatchException(InputMismatchException ex) {
		if (ex.getMessage() != null) {
			System.out.println("Erro de entrada: " + ex.getMessage());
		} else {
			System.out.println("O valor inserido não é válido.");
		}
	}

	public static void handleNegativeNumberException() {
		System.out.println("Não são permitidos números negativos.");
	}
}
