package es.iessaladillo.consoleInput;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ConsoleInput myConsole = new ConsoleInput(keyboard);
		int numInt;
		byte numByte = 120;
		char letra;

		//letra = this.keyboard;
		// letra = keyboard.next();

		/*numByte = myConsole.readByte();
		System.out.printf("El número tipo byte devuelto es %d", numByte);*/

		//char l = myConsole.readChar();
		//		numByte = myConsole.readByteLessThan(numByte);
		//		System.out.printf("El número tipo byte devuelto es %d", numByte);
		//		
		//		numByte = myConsole.readByteLessOrEqualThan(numByte);
		//		System.out.printf("El número tipo byte devuelto es %d", numByte);

		//numByte = readByte();
		//numByte = ConsoleInput.readByte();
		//numByte = Excepciones.ConsoleInput.readByte();
		letra = myConsole.readChar();
	}
}