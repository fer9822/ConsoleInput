package es.iessaladillo.consoleInput.src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import es.iessaladillo.consoleInput.ConsoleInput;

class ConsoleInputTest {

	// readChar

	@DisplayName("Should readChar return the character scanned")
	@Test
	void readCharWhenChar() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("A");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readChar();

		assertEquals('A', character);
	}

	@DisplayName("Should readChar call nextLine() again after a string of more than one character")
	@Test
	void readCharWhenInvalidString() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("hola", "a");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readChar();

		verify(keyboard, times(2)).nextLine();
		assertEquals('a', character);
	}

	@DisplayName("Should readChar call nextLine() again after an empty string")
	@Test
	void readCharWhenEmptyString() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextLine()).thenReturn("", "c");
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		char character = consoleInput.readChar();

		verify(keyboard, times(2)).nextLine();
		assertEquals('c', character);
	}

	// readByte

	@DisplayName("Should readByte return the byte scanned")
	@Test
	void readByteWhenByte() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenReturn((byte) 8);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByte();

		assertEquals(8, number);
	}

	@DisplayName("Should readByte call nextByte() again after the user has not entered a number")
	@Test
	void readByteWhenNonByte() {
		Scanner keyboard = mock(Scanner.class);
		when(keyboard.nextByte()).thenThrow(new InputMismatchException()).thenReturn((byte) 10);
		ConsoleInput consoleInput = new ConsoleInput(keyboard);

		byte number = consoleInput.readByte();

		verify(keyboard, times(2)).nextByte();
		assertEquals(10, number);
	}

}