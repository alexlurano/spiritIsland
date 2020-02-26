package testPack;
import java.util.*;

public class Board {
	char[] tileIndex = {'a','a','a','a','a','a','a','a'};
	int boardNumber = 0;
	Tile[] tileInfo = new Tile[8];
	

	

	public void printJob(String args) { System.out.println(args); }
	public void assignTiles( ) {

		switch(boardNumber) {
		case 0:
			char[] tempIndex1 = {'m','w','j','s','w','m','s','j'};
	        for (int i=0; i<8; i++) 
	            tileIndex[i] = tempIndex1[i];

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
	
	private void initBaddies() {
		int citySpot = ((boardNumber % 3)+1);
		tileInfo[citySpot].addInvader("City", 1);
		
	}
	public void defineTiles() {
		for(int i = 0; i < 8; i++) {
			tileInfo[i] = new Tile(boardNumber, i, tileIndex[i]);
		}
	}

	public Board(int args) {
		boardNumber = args;
		assignTiles();
		defineTiles();
		initBaddies();

	}
	
	public void invaderAction(String exploreSpots, String buildSpot, String ravageSpot) {
		printJob(exploreSpots+buildSpot+ravageSpot+boardNumber);
	}
	
	public String toString() {
		String returnString = "";
		returnString ="boardnumber: " + boardNumber + "\n";
		returnString += "Quickreference " + Arrays.toString(tileIndex);
		for(int i=0;i<tileInfo.length;i++)
			returnString += "\n" +tileInfo[i].toString();
//		if(boardNumber == 0)
//			returnString += "invader deck has " +invaderDeck.getNumberOfCards(); // I dont like that the invader deck
		return returnString;													//is part of board 1 plz change it
	}

}
