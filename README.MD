## Blackjack Project - Week 4 Skill Distillery

### Application Overview
This application is a functional command line blackjack game. The application is broken down into reusable classes and enums. The deck of cards uses the class of the card which uses the enums Suit and Rank. Each player has their own hand and their own class. The cards are dealt to the players and removed from the deck of cards. I then check to see if the inital cards dealt contains blackjack or bust for the player and show the one face up card for the dealer. I then ask the user for input choosing either 1 or 2 to hit or stay. If the user chooses to hit a card is removed from the deck and added to the players class which adds it to the players BlackjackHand which inherits the abstract class of Hand. I then check to see if the player has blackjack or bust. i then use recursion to ask the player if they want to hit or stay again. If the user chooses to stay using 2 then it is the dealers turn. The dealer uses a while loop to deal cards until they reach 17. I continue to check if the dealer has blackjack or bust. When either the dealer or the player wins or loses I show the final hands of both player and dealer along with the hand value. I then use recursion to ask the user they want to play again.

### Technologies Used

* Java
* Eclipse
* Git
* Github

###### Lessons Learned

* I learned how to build classes in an object oriented manner.
* I learned to build classes whose fields are objects.
* I practiced writing methods.
* I learned how to use collections to organize data.
* I learned how to implement some game logic for black jack.