/* 
 * Name: Yi-Wen Chu    991624614
 * Assignment: Exercise 1 
 * Program: Computer Systems Technology -
 * 	Software Development and Network Engineering
 * File: CardTrick.java
 * 
 * 
 * Date: Jun 4, 2021
 */
package ca.sheridancollege.week3.softwarefundamentals.exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * asks the user to pick a card and searches the array of cards for the match to
 * the user's card. To be used as starting code in ICE 1
 * 
 * @author dancye
 * Modified by @author Yi-Wen Chu, June 4, 2021.
 */
public class CardTrick {

	public static void main(String[] args) {
		Card[] magicHand = new Card[7];

		for (int i = 0; i < magicHand.length; i++) {
			Card c = new Card();
			// Set a random value for card.
			c.setValue((int) (Math.random() * 13) + 1);
			// Set a random suit for card.
			c.setSuit(Card.SUITS[(int) (Math.random() * 3)]);
			
			magicHand[i] = c;
		}

		// insert code to ask the user for Card value and suit, create their card
		Scanner input = new Scanner(System.in);

		try {
            		Card pickedCard = new Card();
			pickedCard.setSuit(inqSuit(input));
			pickedCard.setValue(inqValue(input));
			System.out.println("You pick " +pickedCard);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			input.close();
		}

		// and search magicHand here
		// Then report the result here
	}

	public static String inqSuit(Scanner input) {

		// Message for asking the user to pick a suit. 
		System.out.println("Pick a suit: (Answer by the number.)");
		System.out.print("1. " + Card.SUITS[0] + 
							"\n2. " + Card.SUITS[1] + 
							"\n3. " + Card.SUITS[2] + 
							"\n4. " + Card.SUITS[3] + 
							"\nYou pick: ");
		
		// Exception handling while picking a suit.
		// Only 1 to 4 available.
		String inputSuit = null;
		try {
			inputSuit = Card.SUITS[input.nextInt()-1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(
					"You pick a suit not in the list.", e);
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException(
					"Please answer the picked suit by integer number.", e);
		}

		return inputSuit;
	}
	
	/**
	 * Inquires the data of value.
	 *
	 * @param input the input
	 * @return the int
	 */
	public static int inqValue(Scanner input) {

		// Message for asking the user to pick a value.
		System.out.println("Pick a value: ");
		System.out.print("Answer by 1 to 13. " + 
							"1 for Ace, " +
							"11 for Jack, 12 for Queen and 13 for King." +
							"\nYou pick: ");

		// Exception handling while picking a value.
		// Only 1 to 13 available.
		int inputValue = 0;
		try {
			inputValue = input.nextInt();
			if(inputValue > 13 || inputValue < 1)
				throw new IllegalArgumentException(
						"The value is only available from 1 to 13.");
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException(
					"Please answer the value by integer number.", e);
		}
		
		return inputValue;
	}

}
