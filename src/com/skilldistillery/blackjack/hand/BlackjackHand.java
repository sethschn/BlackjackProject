package com.skilldistillery.blackjack.hand;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.cards.Card;

public class BlackjackHand extends Hand {
	private List<Card> listHand;
	private String name;

	public BlackjackHand(String name) {
		super();
		listHand = this.getCards();
		this.name = name;
	}

	@Override
	public int getHandValue() {
		//super.getCards();
		return super.getTotalValue();
	}

	public boolean isBlackjack() {
		if (this.getTotalValue() == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		if (this.getTotalValue() > 21) {
			return true;
		} else {
			return false;
		}
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hand " + listHand + ", \nValue: " + getHandValue() + ".\n";
	}
}
