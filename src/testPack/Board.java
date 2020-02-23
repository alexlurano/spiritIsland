package testPack;
import java.util.*;

public class Board {
	char[] tileIndex = {'a','a','a','a','a','a','a','a'};
	int boardNumber = 0;
	Tile[] tileInfo = new Tile[8];
	Deck invaderDeck;
	Deck fearDeck;
	

	
	
	public void assignTiles( ) {

		switch(boardNumber) {
		case 0:
			char[] tempIndex1 = {'m','w','j','s','w','m','s','j'};
	        for (int i=0; i<8; i++) 
	            tileIndex[i] = tempIndex1[i];
			invaderDeck = new Deck('i');
			//System.out.println(invaderDeck.toString());

			//--------------------------------------------------------------------------------------------
			// attempt to create the fear deck, fear deck and invader deck and event deck assigned to board 1 for now;
			
			fearDeck = new Deck('f');
			String[] tempFearNames = {"aa","bb","cc","dd","ee","ff","gg","hh","ii"};
			fearDeck.populateDeck(tempFearNames, "Fear");
			break;
		case 1:
			char[] tempIndex2 = {'w','m','s','j','s','w','m','j'};
	        for (int i=0; i<8; i++) 
	            tileIndex[i] = tempIndex2[i];

			break;
		case 2:
			char[] tempIndex3 = {'j','s','m','j','w','s','m','w'};
	        for (int i=0; i<8; i++) 
	            tileIndex[i] = tempIndex3[i];

			break;
		case 3:
			char[] tempIndex4 = {'w','j','w','s','m','j','s','m'};
	        for (int i=0; i<8; i++) 
	            tileIndex[i] = tempIndex4[i];

			break;
		default:
			System.out.println("invalid board number");
			char[] tempIndex5 = {'a','a','a','a','a','a','a','a'};
	        for (int i=0; i<8; i++) 
	            tileIndex[i] = tempIndex5[i];
									
		}
	}
	
	public void defineTiles() {
		for(int i = 0; i < 8; i++) {
			tileInfo[i] = new Tile();
			tileInfo[i].populateTileInfo(boardNumber, i, tileIndex[i]);
		}
	}

	public Board(int args) {
		boardNumber = args;
		assignTiles();
		defineTiles();

	}
	
	public void invaderAction(char exploreSpots, char buildSpot, char ravageSpot, char[] additionalAction,int[] additionaIndex) {
		for(int i=0;i<8;i++) {
			if(exploreSpots == tileIndex[i])
				tileInfo[i].explore();
		}
	}
	
	public String toString() {
		String returnString = "";
		returnString ="boardnumber: " + boardNumber;
		if(boardNumber == 0)
			returnString += "invader deck has " +invaderDeck.getNumberOfCards();
		return returnString;
	}

}
