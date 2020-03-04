package testPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.google.gson.JsonArray;


import controller.UserInteractionHandler;
import jsonReader.DeckMaker;
import structural.Deck;
import structural.PowaCard;
import structural.Spirit;
import view.PlayerView;

public class GameContainer {
	
	UserInteractionHandler guiContainer;
	boolean gameNotOver = true;
	
	PlayerView[] players = new PlayerView[4];
	Board[] boards;
	Deck invaderDeck;
	Deck fearDeck;
	Deck minorPowers;
	Deck majorPowers;
	Deck startCards;
	String[] invaderUpcoming = {"NA","NA","NA"};
	String[] stageArray = {"Growth","Bird","Events","Fear","Invaders","Turtle"};
	String[] tempSpiritMaker = {"Bringer of Dreams and Nightmares",
			"Oceans Hungry Grasp",
			"Sharp Fangs Behind the Leaves",
			"Keeper of the Forbidden Wilds"};
	boolean[] spiritIsReady = {false, false, false, false};





	public void printJob(String args) { System.out.println(args); }
	public GameContainer() {
		// TODO Auto-generated constructor stub
	}

	
	public void doStuff() {
		//--------------------------------------------------------------------------------------------
		// initialize 1 board per player: todo assign board to player and limit amount to player amount
		boards = new Board[4];
		for(int i =0;i<4;i++){
			boards[i] = new Board(i);
			players[i] = new PlayerView(tempSpiritMaker[i]);
		}	
		//-------------------------------------------------------------------------------------------
		// create powers from JSON after testing make sure it returns a deck w/ vals assignd

		makePowerDecks();

		
		//--------------------------------------------------------------------------------------------
		// attempt to create invader deck using Deck object

		makeInvaderDeck();

		//--------------------------------------------------------------------------------------------
		// attempt to create the fear deck, fear deck and invader deck and event deck assigned to board 1 for now;
		
		fearDeck = new Deck('f');
		String[] tempFearNames = {"aa","bb","cc","dd","ee","ff","gg","hh","ii"};
		fearDeck.populateDeck(tempFearNames, "Fear");	
		
		// main loop for game

		String currentStage = "Invaders";
		guiContainer = new UserInteractionHandler();
		guiContainer.recieveCards(minorPowers, majorPowers,startCards);
		guiContainer.guiMethod();
		
			int i = 0;
			while(gameNotOver) {
				
				stageManager(currentStage);
				currentStage = stageArray[i];
				i++;
				if(i==stageArray.length)
					i=0;
				break;
			}
		
	}
	
	public void giveStarterCards() {
		for(PlayerView p:players) {
			
		}
	}
	public void assignCard(PowaCard aCard, int playernum) {
		players[playernum].addCard(aCard);
		
	}

	private void stageManager(String loadedStage) {// this is hideous a
		
		if((loadedStage.compareTo("Invaders")==0)) {
			printJob("Invader move");
			
			for(int i=0;i<boards.length;i++)
			{
				boards[i].invaderAction(invaderUpcoming[0], invaderUpcoming[1], invaderUpcoming[2]);
			}
			invaderUpcoming[2] = invaderUpcoming[1];
			invaderUpcoming[1] = invaderUpcoming[0];
			if(invaderDeck.getNumberOfCards() <= invaderDeck.getdrawSpot()) {
				gameNotOver = false;
				return;
			}
			invaderUpcoming[0] = invaderDeck.drawCard(1);
		} else {
			printJob(loadedStage + "unhandled");
		}
		
		//userInteractionRequired();
	}
	

	
	
	

	
	public void makePowerDecks() {
		DeckMaker temp = new DeckMaker();
		JsonArray cardToWrite = new JsonArray();
		cardToWrite = temp.openJson("minor");
		minorPowers = new Deck('s'); // s means minor, i could change this to string for readability
		// create cards with names
		minorPowers.powerCardInfo(cardToWrite,cardToWrite.size());
		//------------------------------------------------------------------------
		majorPowers = new Deck('m'); // m means major
		
		cardToWrite = temp.openJson("major");
		majorPowers.powerCardInfo(cardToWrite,cardToWrite.size());

		//------------------------------------------------------------------------	
		startCards = new Deck('s'); // s means starting
		
		cardToWrite = temp.openJson("start");
		startCards.powerCardInfo(cardToWrite,cardToWrite.size());
		
	}
	
	private void makeInvaderDeck() {
		invaderDeck = new Deck('i');
		//draw first card
		invaderUpcoming[0] = invaderDeck.drawCard(1);
	}
	


}
