package testPack;

import java.util.*;

public class MainBoard {
	Spirit[] Players = new Spirit[4];
	Board[] boards;
	String[] tempSpiritMaker = {"Bringer of Dreams and Nightmares",
			"Oceans Hungry Grasp",
			"Sharp Fangs Behind the Leaves",
			"Keeper of the Forbidden Wilds"};
	
	
	
	public MainBoard() {
		// TODO Auto-generated constructor stub
	}

	
	public void doStuff() {


		//Invaders currentEnemies = new Invaders();
		// create objects for each player todo allow each player to choose from list
		//Players = new Spirit[4];

		//--------------------------------------------------------------------------------------------
		

		// initialize 1 board per player: todo assign board to player and limit amount to player amount
		boards = new Board[4];
		for(int i =0;i<4;i++){
		boards[i] = new Board(i);

		Players[i] = new Spirit(tempSpiritMaker[i],i+1);
		}
		
		//--------------------------------------------------------------------------------------------
		// attempt to create invader deck using Deck object
		

		
		
		
		//user stuff
		userInteraction playerInputContainer = new userInteraction();
		ArrayList<String> userRequestedData = new ArrayList<String>();
		
		playerInputContainer.recieveAllObjects(Players, boards);
		playerInputContainer.askThePlayer();
//		userRequestedData.addAll(playerInputContainer.getInfoSoFar(false));
//		userRequestedData.addAll(playerInputContainer.getInfoSoFar(true));
//		System.out.println(userRequestedData);



	}
	public Spirit getSpirit(int indx) {
/*		if(Players[indx] != null)
			return Players[indx];
		else {*/
		System.out.println(Players[1].toString());
			Spirit mistake = new Spirit("null",1);
			return mistake;
					
		//}
	}

}
