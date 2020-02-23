package testPack;

public class Tile {
	int tileNumber;
	int boardNumber;
	char landType = 'a';
	boolean invadersPresent = false;
	boolean isCoastal = false;
	
	int[] numInvaderType = {0,0,0};
	
	public void printJob(String args) {
		System.out.println(args);
	}
	public Tile() {
		// TODO Auto-generated constructor stub
	}
	
	public void populateTileInfo(int boardNum, int tileNum, char landTy) {

		tileNumber = tileNum;
		boardNumber = boardNum;
		landType = landTy;
		if(tileNum <= 3)
			isCoastal = true;
	}
	
	public void explore() {
		printJob("I tried to explore in tilenumber " + tileNumber + "on Board number " + boardNumber);
	}
	
	public void build() {
		printJob("I tried to build in tilenumber " + tileNumber + "on Board number " + boardNumber);
	}
	
	public void ravage() {
		printJob("I tried to ravage in tilenumber " + tileNumber + "on Board number " + boardNumber);
	}

}
