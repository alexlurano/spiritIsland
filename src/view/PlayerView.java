package view;

import java.util.ArrayList;

import structural.PowaCard;

public class PlayerView {

	String myName;
	ArrayList<PowaCard> myHand = new ArrayList<PowaCard>();
	public PlayerView(String args) {
		myName = args;
	}
	
	public String getmyName() {
		return myName;
	}
	
	public void addCard(PowaCard args) {
		myHand.add(args);
	}
	
	public ArrayList<PowaCard> getHand() {
		return myHand;
	}

}
