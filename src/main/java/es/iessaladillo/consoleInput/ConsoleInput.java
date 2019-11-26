package es.iessaladillo.consoleInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {

	private final Scanner keyboard;

	public ConsoleInput(Scanner keyboard) {
		this.keyboard = keyboard;
	}

	private void cleanInput() {
		keyboard.nextLine();
	}

	/**
	 * Este metodo comprueba si el numero introducido por el usuario es de tipo
	 * byte, sino es de tipo byte, se le comunica mediante un mensaje en consola y
	 * se vuelve a pedir el numero al usuario
	 * 
	 * @author Antonio Serrano
	 * @version 1.0
	 * @since 1.0
	 * 
	 * @return devuelve un byte
	 */
	public byte readByte() {

		boolean option = false;
		byte numByte = 0, min = -128, max = 127;

		do {
			option = true;
			try {
				System.out.println("Introduzca un número tipo byte");
				numByte = this.keyboard.nextByte();

				if (numByte >= min && numByte <= max) {
					//el siguiente system out es para comprobar que funciona, luego hay que quitarla
					//Comentar el system.out para que no salga en el mayor, menor, etc.				
					System.out.println("Número tipo byte correcto");
				}
				// con este catch detecta si el número no está en el rango
			} catch (NumberFormatException e) {
				System.out.println("Error se ha salido del rango");
				System.out.printf("Dime un número entre el -128 y el 127, por favor\n");
				option = false;
				// con el catch se detecta que el número no es del tipo byte y volvemos a pedirlo	
			} catch (InputMismatchException e) {
				System.out.printf("Dime un número entre el -128 y el 127, por favor\n");
				option = false;
			} finally {
				cleanInput(); // Para limpiar el buffer
			}
		} while (!option);
		return numByte;
	}

	/**
	 * Este metodo devuelve un byte entre el valor minimo del tipo byte (-128) y el
	 * valor maximo excluido, introducido por el usuario que llama a la funcion
	 * 
	 * @author Antonio Serrano
	 * @version 1.0
	 * @since 1.0
	 * 
	 * @param upperBound
	 * @return devuelve un byte
	 */
	public byte readByteLessThan(byte upperBound) {

		boolean option = false;
		byte numByte = 0, min = -128, max = upperBound;

		do {
			try {
				System.out.printf("Introduce un número entre %d y %d\n", min, max);
				numByte = this.keyboard.nextByte();
				if (numByte >= min && numByte < max) {
					System.out.println("Número tipo byte dentro del rango exluido máximo");
					option = true;
				}
			} catch (InputMismatchException e) {
				System.out.printf("Dime un número mayor que %d y menor que %d", min, max);
				option = false;
			} finally {
				cleanInput(); // Para limpiar el buffer
			}
			System.out.println();
		} while (!option);
		return numByte;
	}

	/**
	 * Este metodo devuelve un byte entre el valor minimo del tipo byte (-128) y el
	 * valor maximo incluido, introducido por el usuario que llama a la funcion
	 * 
	 * @author Antonio Serrano
	 * @version 1.0
	 * @since 1.0
	 * 
	 * @param upperBound
	 * @return devuelve un byte
	 */
	public byte readByteLessOrEqualThan(byte upperBound) {

		boolean option = false;
		byte numByte = 0, min = -128, max = upperBound;

		do {
			try {
				numByte = this.keyboard.nextByte();
				if (numByte >= min && numByte <= max) {
					System.out.println("Número tipo byte dentro del rango incluido máximo");
					option = true;
				}
			} catch (InputMismatchException e) {
				System.out.printf("Dime un número entre %d y %d", min, max);
			} finally {
				cleanInput(); // Para limpiar el buffer
			}
		} while (!option);
		return numByte;
	}

	/**
	 * Este metodo devuelve un byte entre el valor minimo (excluido), introducido
	 * por el usuario que llama a la funcion del tipo byte y el valor maximo (127).
	 * 
	 * @author Antonio Serrano
	 * @version 1.0
	 * @since 1.0
	 * 
	 * @param lowerBound
	 * @return devuelve un byte
	 */
	public byte readByteGreaterThan(byte lowerBound) {

		boolean option = false;
		byte numByte = 0, min = lowerBound, max = 127;

		do {
			try {
				numByte = this.keyboard.nextByte();
				if (numByte >= min && numByte < max) {
					System.out.println("Número tipo byte dentro del rango exluido mínimo");
					option = true;
				}
			} catch (InputMismatchException e) {
				System.out.printf("Dime un número mayor que %d y menor que %d", min, max);
				option = false;
			} finally {
				cleanInput(); // Para limpiar el buffer
			}

		} while (!option);
		return numByte;
	}

	/**
	 * Este metodo devuelve un byte entre el valor minimo (incluido), introducido
	 * por el usuario que llama a la funcion del tipo byte y el valor maximo (127).
	 * 
	 * @author Antonio Serrano
	 * @version 1.0
	 * @since 1.0
	 * 
	 * @param lowerBound
	 * @return devuelve un byte
	 */
	public byte readByteGreaterOrEqualThan(byte lowerBound) {

		boolean option = false;
		byte numByte = 0, min = lowerBound, max = 127;

		do {
			try {
				numByte = this.keyboard.nextByte();
				if (numByte >= min && numByte <= max) {
					System.out.println("Número tipo byte dentro del rango incluido máximo");
					option = true;
				}
			} catch (InputMismatchException e) {
				System.out.printf("Dime un número entre %d y %d", min, max);
			} finally {
				cleanInput(); // Para limpiar el buffer
			}
		} while (!option);
		return numByte;
	}

	/**
	 * Este metodo devuelve un byte entre un valor minimo y un maximo introducido
	 * por el usuario ambos números incluidos dentro del rango
	 * 
	 * @author Antonio Serrano
	 * @version 1.0
	 * @since 1.0
	 * 
	 * @param lowerBound, upperBound
	 * @return devuelve un byte
	 */
	public byte readByteInRangeInclusive(byte lowerBound, byte upperBound) {

		boolean option = false;
		byte numByte = 0, min = lowerBound, max = upperBound;

		do {
			try {
				numByte = this.keyboard.nextByte();
				if (numByte >= min && numByte <= max) {
					System.out.printf("Número tipo byte dentro del rango %d y %d ambos incluidos", min, max);
					option = true;
				}

			} catch (InputMismatchException e) {
				System.out.printf("Dime un número entre %d y %d ambos incluidos", min, max);
			} finally {
				cleanInput(); // Para limpiar el buffer
			}
		} while (!option);
		return numByte;
	}

	/**
	 * Este metodo devuelve un byte entre un valor minimo y un maximo introducido
	 * por el usuario ambos numeros excluidos del rango
	 * 
	 * @author Antonio Serrano
	 * @version 1.0
	 * @since 1.0
	 * 
	 * @param lowerBound, upperBound
	 * @return devuelve un byte
	 */
	public byte readByteInRangeExclusive(byte lowerBound, byte upperBound) {

		boolean option = false;
		byte numByte = 0, min = lowerBound, max = upperBound;

		do {
			try {
				numByte = this.keyboard.nextByte();
				if (numByte > min && numByte < max) {
					System.out.printf("Número tipo byte dentro del rango %d y %d ambos excluidos", min, max);
					option = true;
				}

			} catch (InputMismatchException e) {
				System.out.printf("Dime un número entre %d y %d ambos excluidos", min, max);
			} finally {
				cleanInput(); // Para limpiar el buffer
			}
		} while (!option);
		return numByte;
	}

	public char readChar() {
		String string;
		char c;
		boolean condition = false;

		do {
			condition = true;
			string = keyboard.nextLine();
			if (string.length() != 1) {
				System.out.println("No has introducido un caracter válido");
				condition = false;
			}
		} while (!condition);
		System.out.println("Correcto");
		c = string.charAt(0);

		return c;

	}
}
