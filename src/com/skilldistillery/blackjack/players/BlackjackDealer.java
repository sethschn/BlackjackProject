package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.hand.BlackjackHand;

public class BlackjackDealer extends BlackjackPlayer {
	
	private BlackjackHand hand;
	
	public BlackjackDealer() {
		super();
		this.hand = new BlackjackHand("Dealer");
	}
	
	public void hit(Card card) {	
		hand.addCard(card);
	}

	public BlackjackHand getHand() {
		return hand;
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}
	
	

}
