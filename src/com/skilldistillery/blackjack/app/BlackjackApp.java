package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.hand.BlackjackHand;
import com.skilldistillery.blackjack.players.BlackjackDealer;
import com.skilldistillery.blackjack.players.BlackjackPlayer;

public class BlackjackApp {
	public Scanner kb;
	public Deck deckObj;
	public BlackjackPlayer playerObj;
	public BlackjackDealer dealerObj;
	public BlackjackHand playerHand;
	public BlackjackHand dealerHand;

	public BlackjackApp() {
		kb = new Scanner(System.in);
		playerObj = new BlackjackPlayer();
		playerHand = new BlackjackHand("Player");
		deckObj = new Deck();
		deckObj.shuffle(); // start with a shuffled deck
		dealerObj = new BlackjackDealer(deckObj);
		dealerHand = new BlackjackHand("Dealer");

	}

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	public void run() {
		System.out.print("Welcome to Black Jack type (\"Y\") to play: ");
		String userInput = null;
		boolean error = false;
		try {
			userInput = kb.nextLine();
		} catch (Exception e) {
			System.out.println("Invalid input");
			error = true;
			kb.nextLine();
		}
		//System.out.println();
		if (userInput.equalsIgnoreCase("Y") && error == false) {
			// deal player a card
			playerHand.addCard(deckObj.dealCard());
			//deckObj.dealCard(playerHand);
			// deal the dealer a card
			dealerHand.addCard(getCard());
			// deal player a card
			playerHand.addCard(getCard());
			// deal the dealer a card
			//dealerHand.addCardToHand(getCard());
			//playerObj.setHand(playerHand);
			showPlayerHand();
			//dealerObj.setHand(dealerHand);
			showDealerHand();
			//kb.nextLine();
			hitOrStayMenu();				
		}else {
			run();
		}
	}// end run
	
	public void hitOrStayMenu() {
		checkGameOver(playerHand);
		int choice = 0;
		boolean error = false;
		System.out.println("\nWould you like to ");
		System.out.println("1.) Hit");
		System.out.println("2.) Stay");
		System.out.print("Choice (1-2): ");
		try {
			choice = kb.nextInt();
			System.out.println();
			if (choice < 1 || choice > 2) {
				System.out.println("Please enter 1 or 2");
				error = true;
			}
		} catch (Exception e) {
			System.out.println("Invalid input");
			error = true;
			kb.nextLine();
			//hitOrStayMenu();
		}
		if (!error) {		
			switch (choice) {
			case 1:
				// hit
				playerHand.addCard(getCard());
				showPlayerHand();
				//showDealerHand();
				checkGameOver(playerHand); 
				hitOrStayMenu();					
				break;
			case 2:
				// stay
				System.out.println("\t\tDealers turn");
				dealerHand.addCard(getCard());
				dealerTurn();
				break;
			}			
		}
		hitOrStayMenu();
		
	}
	
	public void reset() {
		System.out.println("\n");
		playerHand = new BlackjackHand("Player");
		dealerHand = new BlackjackHand("Dealer");
		deckObj = new Deck();
		deckObj.shuffle();
		kb = new Scanner(System.in);
		run();
	}
	
	public void dealerTurn() {
		showDealerHand();
		while (dealerHand.getHandValue() < 17 ) {
			//System.out.println("Dealer total: "+dealerHand.getHandValue());
			dealerHand.addCard(getCard());
			showDealerHand();
			checkGameOver(dealerHand);
		}
		//showPlayerHand();
		checkFinalGameOver();
		//showDealerHand();
		//System.out.println("Dealer total: "+dealerHand.getHandValue());		
	}
	
	public void checkFinalGameOver() {
		System.out.println("\n\t\tFinal Scores");
		showPlayerHand();
		showDealerHand();
		int dealerValue = dealerHand.getHandValue();
		int playerValue = playerHand.getHandValue();
		if (dealerHand.isBust()) {
			System.out.println("Player wins, dealer busted");
		}else if (playerHand.isBust()) {
			System.out.println("Dealer wins, player busted");
		}
		if (dealerValue > playerValue && dealerValue <= 21 ) {
			if (dealerHand.isBlackjack()) {
				System.out.println("Dealer has blackjack, player loses");
			}else {
				System.out.println("Dealer wins higher value than player");				
			}
		}else if (dealerValue == playerValue) {
			System.out.println("Tie Game");
		}else if (playerValue > dealerValue && playerValue <= 21){
			if (playerHand.isBlackjack()) {
				System.out.println("Player has blackjack, dealer loses");								
			}else {
				System.out.println("Player wins higher value than dealer");				
			}
		}
		System.out.println("Game over");
		reset();
	}
	
	public void checkGameOver(BlackjackHand hand) {
		if (hand.isBust()) {
			System.out.println("\t\t"+hand.getName()+" has busted");
			checkFinalGameOver();
		}else if (hand.isBlackjack()) {
			System.out.println("\t\t"+hand.getName()+" has blackjack");
			checkFinalGameOver();
		}
	}

	public Card getCard() {
		Card dealtCard = deckObj.dealCard();
		return dealtCard;
	}// end getCard()
	
	public void showPlayerHand() {
		System.out.println("Player "+playerHand);
	}
	
	public void showDealerHand() {
		System.out.println("Dealer "+dealerHand);
	}

}// end class
