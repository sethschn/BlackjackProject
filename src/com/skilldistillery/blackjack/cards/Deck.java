package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cardList;

	public Deck() {
		cardList = new ArrayList<>();
		// loop through 52 cards
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cardList.add(new Card(s, r));
			}
		}
	}

	public int checkDeckSize() {
		return cardList.size();
	}
	
	public Card dealCard() {
		return cardList.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(cardList);
	}
}



//Create a class Deck. It will hold a List of Cards.
//In the constructor, initialize the List with all 52 cards.
//Add a method checkDeckSize which returns the number of cards still in the deck.
//Add a method dealCard that removes a Card from the deck.
//Add a method shuffle to shuffle the deck.