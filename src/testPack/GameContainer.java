package testPack;


public class GameContainer {
	boolean gameNotOver = true;
	
	Spirit[] Players = new Spirit[4];
	Board[] boards;
	Deck invaderDeck;
	String[] invaderUpcoming = {"NA","NA","NA"};
	Deck fearDeck;
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

		Players[i] = new Spirit(tempSpiritMaker[i],i+1);
		}
		
		
		//--------------------------------------------------------------------------------------------
		// attempt to create invader deck using Deck object
		

		invaderDeck = new Deck('i');
		//draw first card
		invaderUpcoming[0] = invaderDeck.drawCard(1);
		

		//--------------------------------------------------------------------------------------------
		// attempt to create the fear deck, fear deck and invader deck and event deck assigned to board 1 for now;
		
		fearDeck = new Deck('f');
		String[] tempFearNames = {"aa","bb","cc","dd","ee","ff","gg","hh","ii"};
		fearDeck.populateDeck(tempFearNames, "Fear");	
		
		// main loop for game

		String currentStage = "Invaders";
		
		if(gameNotOver) {
			int i = 0;
			while(true) {
				
				stageManager(currentStage);
				currentStage = stageArray[i];
				i++;
				if(i==stageArray.length)
					i=0;
			}
		}
	}
	

	//user stuff
	private void userInteractionRequired() {
		
	
		userInteraction playerInputContainer = new userInteraction(Players, boards);
		// debug function
		//	playerInputContainer.askThePlayer();
		
		// temporary loop, in the future  add a method to spirit that passes a boolean to
		// an array with an element for each spirit and then checks if all elements are true
		// and if they are, advances stage.
								
		playerInputContainer.advanceStage();
		

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
			invaderUpcoming[0] = invaderDeck.drawCard(1);
		} else {
			printJob(loadedStage + "unhandled");
		}
		userInteractionRequired();
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
