package testPack;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import spiritView.TempDataStorage;

public class CardListParser {

    List<String> linesForDatabase = Collections.emptyList(); 
    String germanfile = "GermanCards.txt";

	public void printJob(String args) { System.out.println(args); }
	public CardListParser() {
		// TODO Auto-generated constructor stub
	}
	
	public void accessInfoFromGermans() { // until i can figure out how to read images use data from oberon
		String projLoc = System.getProperty("user.dir") + "\\" + germanfile;
		printJob(projLoc);
		linesForDatabase = new TempDataStorage().readFileInList(projLoc) ;
	    Iterator<String> itr = linesForDatabase.iterator(); 
	    while (itr.hasNext()) 
	      printJob(itr.next()); 
	}

}
