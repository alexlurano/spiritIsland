package testPack;


import java.util.*;

public class Tile {
	int tileNumber;
	int boardNumber;
	char landType = 'a';


	boolean invadersPresent = false;
	boolean isCoastal = false;
	boolean[] skipArray = {false,false,false,false}; //explore,build,ravage,disease
	int[] numInvaderType = {0,0,0};
	ArrayList<Invader> invadersHere = new ArrayList<Invader>(); 
	

	public void printJob(String args) { System.out.println(args); }
	public Tile(int boardNum, int tileNum, char landTy) {
		// TODO Auto-generated constructor stub
		tileNumber = tileNum;
		boardNumber = boardNum;
		landType = landTy;
		if(tileNum <= 2)
			isCoastal = true;
	}
	
	public String toString() {
		String myInfo = "TileID: {" + tileNumber + "," + boardNumber + "} \n";
		myInfo += "{" + landType + ", " + invadersPresent + ", " + isCoastal + ", ";
		myInfo += Arrays.toString(skipArray) + ", " + Arrays.toString(numInvaderType) + "}";
		return myInfo;
		
	}
	public boolean compareLandType(char inputLand)
	{
		if(inputLand == landType)
			return true;
		return false;
	}
	


	public String getInvaderInfo() {
		String invaderBlob;
		invaderBlob = "bb";
		return invaderBlob;
	}
	
	
	public int getTileNumber() {
		return tileNumber;
	}
	public void setTileNumber(int tileNumber) {
		this.tileNumber = tileNumber;
	}
	public char getLandType() {
		return landType;
	}
	public void setLandType(char landType) {
		this.landType = landType;
	}
	public boolean isInvadersPresent() {
		return invadersPresent;
	}
	public void setInvadersPresent(boolean invadersPresent) {
		this.invadersPresent = invadersPresent;
	}
	public boolean isCoastal() {
		return isCoastal;
	}
	public void setCoastal(boolean isCoastal) {
		this.isCoastal = isCoastal;
	}
	public boolean[] getSkipArray() {
		return skipArray;
	}
	public void setSkipArray(boolean[] skipArray) {
		this.skipArray = skipArray;
	}
	public int[] getNumInvaderType() {
		return numInvaderType;
	}
	public void setNumInvaderType(int[] numInvaderType) {
		this.numInvaderType = numInvaderType;
	}
	public ArrayList<Invader> getInvadersHere() {
		return invadersHere;
	}
	
	
	/* this replaces set for invaders. critical that it has these args.
	 * called in board class
	 * this function cannot be removed and must be assigned here in tiles 
	 * ALL cards and innate powers will not work without this and removeInvader.
	 */
	public void addInvader(String whatType,int howMany) { 
		for(int i=0;i<howMany;i++)
			invadersHere.add(new Invader(whatType));
	}


}
