/* 
 * Name: Yi-Wen Chu    991624614
 * Program: Computer Systems Technology -
 * 	Software Development and Network Engineering
 * File: Card.java
 * Main class: CardTrick.java
 * 
 * Date: Jun 4, 2021
 */
package ca.sheridancollege.week3.softwarefundamentals.exercise1;

/**
 * A class that models playing card Objects. Cards have 
 * a value (note that Ace = 1, Jack -11, Queen =12, King = 13)
 * A suit (clubs, hearts, spades, diamonds).
 * There are 52 cards in a deck, no jokers.
 * This code is to be used in ICE1. When you create your own branch,
 * add your name as a modifier.
 * @author dancye
 * Modified by @author Yi-Wen Chu, June 4, 2021.
 */
public class Card {

   private String suit; //clubs, spades, diamonds, hearts
   private int value;//1-13

   /** The Constant SUITS. */
   public static final String [] SUITS = {"Hearts", "Diamonds", "Spades", "Clubs"};
   
   
    /**
     * Gets the suit.
     *
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Sets the suit.
     *
     * @param suit the suit to set
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    /**
     * Sets the suit by index.
     * 1 = Hearts
     * 2 = Diamonds
     * 3 = Spades
     * 4 = Clubs
     *
     * @param suitNo the number of suit index.
     */
    public void setSuit(int suitNo) {
        try {
        	this.suit = SUITS[suitNo-1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException(
					"You pick a suit not in the list.", e);
		}
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the value to set
     */
    public void setValue(int value) {
    	if(value > 13 || value < 1)
			throw new IllegalArgumentException(
					"The value is only available from 1 to 13.");
        this.value = value;
    }

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String valueStr = null;
		switch (value) {
			case 1: valueStr = "Ace";
				break;
			case 11: valueStr = "Jack";
				break;
			case 12: valueStr = "Queen";
				break;
			case 13: valueStr = "King";
				break;
			default: valueStr = Integer.toString(value);
		}
		return getSuit() +" "+ valueStr;
	}
    
	
	/**
	 * Compare the input card if it is the same card.
	 *
	 * @param obj the input card.
	 * @return true, if it is the same card.
	 */
	@Override
	public boolean equals(Object obj) {
		Card inputObj = (Card) obj;
		return suit.equalsIgnoreCase(inputObj.getSuit()) && 
				value == inputObj.getValue();
	}
}
