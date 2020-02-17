package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.hand.BlackjackHand;

public class BlackjackPlayer extends Player {
	
	private BlackjackHand hand;
	
	public BlackjackPlayer() {
		hand = new BlackjackHand("Player");
	}
	
	
	public void hit(Card card) {	
		hand.addCard(card);
	}

	public void stand() {
		System.out.println("Stand");
	}

	public BlackjackHand getHand() {
		return hand;
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}
}
