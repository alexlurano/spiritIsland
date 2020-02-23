package testPack;

import java.io.*;
import java.util.ArrayList;;

public class userInteraction {
	ArrayList<String> returningInfo;
	BufferedReader myObj;
	Spirit requestedSpirit[];
	Board requestedBoard[];
	
	public userInteraction() {

		myObj = new BufferedReader(new InputStreamReader(System.in));
		returningInfo = new ArrayList<String>();
		returningInfo.add("objectwanted");
		returningInfo.add("objectwantedIndice");
	}
	
	public ArrayList<String> getInfoSoFar(boolean endInput) {
		if(endInput)
			closeReader();
//		System.out.println(cloneSpirit.toString());
		returningInfo.set(0, requestedSpirit.toString());
		returningInfo.set(1, requestedBoard.toString());
		return returningInfo;
	}
	
	public void recieveAllObjects(Spirit[] mySpirit,Board[] myBoard) {
		requestedSpirit = mySpirit;
		requestedBoard = myBoard;
		
	}
	


	
	
	
	public void askThePlayer()  {
		int indx;
	     
		
		try {		
			indx = promptUser("Select player to inspect, valid inputs are: 1,2,3,4");
			tellUserAbout(true,indx);
			promptUser("Select board to inspect, valid inputs are: 1,2,3,4");  // Read user input
			tellUserAbout(false,indx);

	    } catch (IOException ex1) {
			System.out.println("fucked up in user interaction " + ex1.toString());
		}
		
	}
	
	private int promptUser(String displayMessage) throws IOException {
		int optionPicked = -1;
		
	    System.out.println(displayMessage);
	    optionPicked = Integer.parseInt(myObj.readLine()) - 1;  // Read user input
		return optionPicked;
				
	}
	
	private void tellUserAbout(boolean isPlayer, int indxn) {
		if (isPlayer)
			System.out.println(requestedSpirit[indxn].toString());
		else
			System.out.println(requestedBoard[indxn].toString());
	}
	
	private void closeReader() {
		

		try {
			myObj.close();
		} catch (IOException e1) {
			System.out.println("fucked up trying to close reader " + e1.toString());
		}
				
			
	}

}
