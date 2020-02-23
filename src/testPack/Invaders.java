package testPack;
import java.util.*;
/**
 * 
 */

/**
 * @author agerh
 *
 */
public class Invaders {
	char[] lands = {'j','s','m','w'};
	int invasionStage = 0;
	boolean[] invaderActions = {false,false,false,false};
	boolean adversary = false;
	boolean scenario = false;
	int[] targetedLands = {0,0,0,0}; // sands, wetlands, jungle, mountains
	int[] landCounter = {4,4,4,4};

	/**
	 * 
	 */
	public Invaders() {
		// TODO Auto-generated constructor stub
		System.out.println("Generating setup for the Invaders!");
	}
	
	public String nextAction() {
		int diceRoll = (int) (System.currentTimeMillis() % 4);
		if(landCounter[diceRoll] != 0) {
			landCounter[diceRoll] -= 1;
			return "fatbutts" + lands[diceRoll];
		} else {
			return "fatbutts0" + lands[diceRoll];
		}
	}
	


	/**
	 * @param args
	 */


}
