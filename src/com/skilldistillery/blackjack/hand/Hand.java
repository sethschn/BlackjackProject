package com.skilldistillery.blackjack.hand;

import java.util.*;

import com.skilldistillery.blackjack.cards.Card;

public abstract class Hand {
	private List<Card> cards;
	private int totalValue;
	
	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
		totalValue += card.getValue();
	}
	
	public void clear() {
		cards = new ArrayList<>();
	}
	
	public abstract int getHandValue() ;

	@Override
	public String toString() {
		return "Hand cards" + cards + ".";
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	

}
