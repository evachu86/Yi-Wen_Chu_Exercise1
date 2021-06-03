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

import java.util.Arrays;

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
		StringBuilder magicHandStr = new StringBuilder();

		for (int i = 0; i < magicHand.length; i++) {
			Card c = new Card();
			// Set a random value for card.
			c.setValue((int) (Math.random() * 13) + 1);
			// Set a random suit for card.
			c.setSuit(Card.SUITS[(int) (Math.random() * 3)]);
			
			magicHand[i] = c;
			// Use for result report later.
			magicHandStr.append(c).append(", ");
		}

		// insert code to ask the user for Card value and suit, create their card
		// replaced by pick lucky card now.
		Card luckyCard = inqByLuckyCard();
		System.out.println("Pick a lucky card: "+luckyCard+"\n");
		
		System.out.println("The cards in magic hand are: \n" +
		magicHandStr.deleteCharAt(magicHandStr.length()-2));
		// and search magicHand here
		if(Arrays.stream(magicHand)
				.anyMatch(luckyCard::equals)) {
			// Then report the result here
			System.out.println("You WIN!!!!");
		} else {
			System.out.println("You lose.");
		}
	}

	public static Card inqByLuckyCard() {
		Card luckyCard = new Card();
		luckyCard.setSuit(3);
		luckyCard.setValue(1);
		
		return luckyCard;
	}

}
