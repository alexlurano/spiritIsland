package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import structural.Deck;

public class UserInteractionHandler {
	Deck minorPower;
	Deck majorPower;
	Deck startCards;
	String[] majorNames;
	String[] minorNames;
	String[] startNames;
	ArrayList<ActionListener> listenerMethodArr = new ArrayList<ActionListener>();
	FullCardListExplorer windowtrial;
	public UserInteractionHandler() {
		// TODO Auto-generated constructor stub
	}
	public void printJob(String args) { System.out.println(args); }
	
	public void recieveCards(Deck minor, Deck major, Deck starter) {
		minorPower = minor;
		majorPower = major;
		startCards = starter;
				
	}
	
	public void guiMethod() {
		populateActionListeners();
		int indx = minorPower.getNumberOfCards();
		minorNames = new String[indx];
		int indx2 = majorPower.getNumberOfCards();
		majorNames = new String[indx2];
		startNames = new String[startCards.getNumberOfCards()];
		majorNames = getNamesOf(majorPower);
		minorNames = getNamesOf(minorPower);
		startNames = getNamesOf(startCards);
		
		minorPower.setdrawSpot(0);
		JFrameWrapper hackJob = new JFrameWrapper();
		windowtrial = new FullCardListExplorer(hackJob.getJFrame());
		windowtrial.addInfoToList(minorNames,majorNames,startNames);
		windowtrial.createWindow();
		windowtrial.assignListener(listenerMethodArr.get(0),0);
		windowtrial.assignMouseListener(myMouseListeners("major"),0);
		windowtrial.assignMouseListener(myMouseListeners("minor"),1);
		windowtrial.assignMouseListener(myMouseListeners("start"),2);
		windowtrial.showWindow();
		
	}
	
	public String[] getNamesOf(Deck aDeck) {
		String[] nameArr = new String[aDeck.getNumberOfCards()];
		for(int a=0;a<nameArr.length;a++)
		{

			nameArr[a] = aDeck.getCard(a).getName();
		}
		return nameArr;
	}
	
	public void resetDropDown(String butnName) {
		windowtrial.changeDropDown(butnName);
	}
	
	public String[] getCardDetails(String deckType, int index) {
		switch (deckType) {
		case "minor":
			return minorPower.getCard(index).toStringArray();
		case "major":
			return majorPower.getCard(index).toStringArray();
		case "start":
			return startCards.getCard(index).toStringArray();
		default:
			return minorPower.getCard(index).toStringArray();
		}
			
		
	}
	
	public void getImagePath(String name) {
		String rawPath = name;
		rawPath = rawPath.strip();
		rawPath = rawPath.toLowerCase();
		rawPath = rawPath.replaceAll("'", "");

		rawPath = System.getProperty("user.dir") + "\\src\\data\\imgs\\" + rawPath +".jpg";
		windowtrial.setresponse(rawPath);
		windowtrial.addImage(rawPath);
	}
	
	
	private MouseListener myMouseListeners(String butnName)	{
		
	
		MouseListener myMouseListener = new MouseListener(){
		
		@Override
		public void mouseClicked(MouseEvent e) {

    		windowtrial.setresponse("clicked");
    		resetDropDown(butnName);
    		windowtrial.assignListener(listenerMethodArr.get(0),0);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
    };
    return myMouseListener;
	}
	
	private void populateActionListeners() {
		listenerMethodArr.add(new ActionListener() {	
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	windowtrial.setCardValues(getCardDetails(windowtrial.displayedType,windowtrial.getchoiceIndex()));

	        	getImagePath(windowtrial.getItemChoice());
	    		windowtrial.setresponse(windowtrial.getItemChoice());
	        	//windowtrial.updateDropDown(selctn);
	        }
			
		});
		listenerMethodArr.add(new ActionListener() {	
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	//String[] selctn = majorPower.getCard(windowtrial.getchoiceIndex()).toStringArray();
		           // windowtrial.updateDropDown(selctn);
		        }
				
			});
		
	}

}
