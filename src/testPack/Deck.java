package testPack;

import java.util.*;

public class Deck {
	String deckName;
	int numberOfCards = 0; // power cards and spirit hands should always start with the same amount, fear and invader deck depends on opponent.
	Card[] cardsInDeck;
	
	public Deck(char typeOfDeck) {
		// todo: check adversary to alter size of invader and fear decks.
		switch(typeOfDeck) {
			case 'i':
				// create a random invader deck
				deckName = "Invader Deck!";
				createInvaderDeck();
				break;
			case 'f':
				// create a random fear deck
				deckName = "Fear Deck";
				numberOfCards = 9; //Modify this when adversarys are implemented
				cardsInDeck = new Card[numberOfCards];
				break;
			case 's':
				// "shuffle" the minor power deck and create it
				break;
			case 'm':
				// "shuffle" the major power deck and create it
				break;
			case 'p':
				// create spirit starting hand
				deckName = "My Cards!";
				numberOfCards = 4; // scenarios where you start with an extra card not supported
				cardsInDeck = new Card[numberOfCards];
				break;
			case 'e':
				//"shuffle" the event deck.
				break;
			default:
				System.out.println("invalid deck type, valid selections are i,f,s,m,p,e");
				
		}
		
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		String prettyInfo;
		prettyInfo = "" + deckName + " has " + numberOfCards + " access a single card with the inspectCard Method";
		return prettyInfo;
	}
	
	public void addCardToDeck(String cardName, String cardInfo) { // todo: make sure this method is either compatible with adding fear cards or create sep method
		System.out.println(cardName + cardInfo + " addCardToDeck in Deck.java not finished");
	}
	
	private void createInvaderDeck() { // todo: add args for different sized decks depending on adversary
		numberOfCards = 12;
		cardsInDeck = new Card[numberOfCards]; // our deck
		

//------------------------------------------------------------------------------------------------------------------
		
		// 3 string arrays that we must shuffle and then create cards for
		String[] stageOneLands = {"Jungle","Sands","Wetlands","Mountains"};
		String[] stageTwoLands = {"Jungle","Sands","Wetlands","Mountains","Coast"};
		String[] stageThreeLands = {"JungleSands","JungleWetlands","JungleMountains","SandsWetlands","SandsMountains","WetlandsMountains"};
		
//------------------------------------------------------------------------------------------------------------------
		
		// shuffle those bad boys then combine then into one list
		stageOneLands = shuffleMyCards(stageOneLands);
		stageTwoLands = shuffleMyCards(stageTwoLands);
		stageThreeLands = shuffleMyCards(stageThreeLands);
		String[] invaderCardNames = new String[numberOfCards];
		for(int i=0;i<numberOfCards;i++) {
			if(i<stageOneLands.length-1)
				invaderCardNames[i] = stageOneLands[i];
			else if((i-3)<stageTwoLands.length-1)
				invaderCardNames[i] = stageTwoLands[i-3];
			else if((i-7)<stageThreeLands.length-1)
				invaderCardNames[i] = stageThreeLands[i-7];
			else
				System.out.println("Error, unable to finish deck, I made " + (i+1) + " cards, but expected to make " + numberOfCards);
				
		}

//------------------------------------------------------------------------------------------------------------------
		
		// now create actual Cards for the deck that we can interact with
		
		populateDeck(invaderCardNames,"Invader"); // replace hard coded arguement typeOfCard with class variable
//------------------------------------------------------------------------------------------------------------------



		
	}
	
	public void populateDeck(String[] listOfCardNames,String typeOfCard) { // toDO make this method able to create all types of cards
		
		if(typeOfCard == "Invader") {
			for(int i=0;i<numberOfCards;i++) { // creates cards for each name EXCEPT the last one. for invader deck
				cardsInDeck[i] = new Card(typeOfCard,listOfCardNames[i]);
			}
		} else if(typeOfCard == "Power") {
			for(int i=0;i<numberOfCards;i++) { // creates cards for each name EXCEPT the last one. for invader deck
				cardsInDeck[i] = new Card(typeOfCard,listOfCardNames[i]);
			}
		} else if(typeOfCard == "Fear"){
			String[] shuffledListOfFearCardNames = shuffleMyCards(listOfCardNames);
			for(int i=0;i<numberOfCards;i++) { // creates cards for each name EXCEPT the last one. for invader deck
				cardsInDeck[i] = new Card(typeOfCard,shuffledListOfFearCardNames[i]);
			}
		} else {
			System.out.println("creating a deck for " + typeOfCard + " is not yet possible");
			
		}
			
	}
	
	private String[] shuffleMyCards(String[] cardsToShuffle) {
		// create temp storage for shuffling, then return shuffled cards
		String[] shuffledCards = cardsToShuffle;
		
		
		List<String> tempStringListForShuffling = Arrays.asList(shuffledCards);
		Collections.shuffle(tempStringListForShuffling);
		tempStringListForShuffling.toArray(shuffledCards);
		return shuffledCards;
	}
	
	public int getNumberOfCards() {
		return numberOfCards;
	}
	

}
