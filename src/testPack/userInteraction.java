package testPack;

import java.io.*;

public class userInteraction {
	BufferedReader myObj;
	Spirit requestedSpirit[];
	Board requestedBoard[];
	boolean isInteracting;
	

	public void printJob(String args) { System.out.println(args); }
	public userInteraction(Spirit[] mySpirit, Board[] myBoard) {
		requestedSpirit = mySpirit;
		requestedBoard = myBoard;
		printJob("honkhonk");
		isInteracting = true;
		myObj = new BufferedReader(new InputStreamReader(System.in));
	}
	

	public void advanceStage() {
		//int wordOfUser;
		try {
			printJob("presskeyto go");
			myObj.readLine();
			//wordOfUser = Integer.parseInt(askForWords("Advance Stage? press "));
			
			/*if(wordOfUser==1) {
			}
			else {
				System.out.println("bye");
			}*/
		} catch (IOException ex1) {
    		System.out.println("fucked up in user interaction advancing stage " + ex1.toString());
		}
	}


	
	
	
	public void askThePlayer()  {
		int indx;

		while(isInteracting) {
			try {		
				//indx = askForNumber("Select player to inspect, valid inputs are: 1,2,3,4");
				//tellUserAbout(true,indx);
				indx = askForNumber("Select board to inspect, valid inputs are: 1,2,3,4");  // Read user input
				tellUserAbout(false,indx);
				printJob("type 0 to quit");
				if(Integer.parseInt(myObj.readLine()) == 0)
					isInteracting = false;

			} catch (IOException ex1) {
	    		System.out.println("fucked up in user interaction " + ex1.toString());
			}
		}
		
		closeReader();
	}
	
	private int askForNumber(String displayMessage) throws IOException {
		int optionPicked = -1;
		
	    System.out.println(displayMessage);
	    optionPicked = Integer.parseInt(myObj.readLine()) - 1;  // Read user input
		return optionPicked;
				
	}
	
	private String askForWords(String displayMessage) throws IOException {
		String userInput = "";
		System.out.println(displayMessage);
		userInput = myObj.readLine();
		return userInput;
	}
	
	private void tellUserAbout(boolean isPlayer, int indxn) {
		if (isPlayer)
			System.out.println(requestedSpirit[indxn].toString());
		else
			System.out.println(requestedBoard[indxn].toString());
	}
	
	public void closeReader() {
		

		try {
			myObj.close();
		} catch (IOException e1) {
			System.out.println("fucked up trying to close reader " + e1.toString());
		}
				
			
	}

}
