package com.skilldistillery.blackjack.hand;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.blackjack.cards.Card;

public class BlackjackHand extends Hand {
	private String name;

	public BlackjackHand(String name) {
		super();
		this.name = name;
	}

	@Override
	public int getHandValue() {
		//super.getCards();
		return this.getTotalValue();
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
		return "Hand " + this.getCards() + ", \nValue: " + getHandValue() + ".\n";
	}
}
