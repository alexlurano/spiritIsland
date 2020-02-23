package testPack;

public class Spirit {
	String spiritName = "your fat ass";
	Deck myCards; 
	int playerNumber = 0;
	// array of cards in discard
	// int of energy per turn
	// int of card plays per turn
	// define growth options.
	// int of presence on board/ destroyed/ removed/ left on card
	
	
	public Spirit(String theDudeYouPicked,int playerNum) {
		spiritName = theDudeYouPicked;
		Deck myCards = new Deck('p');
		myCards.populateDeck(initialCardList(theDudeYouPicked), "Power");
		playerNumber = playerNum;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		String thisSpiritInfo = "Player number " + playerNumber + "\n" + spiritName;
		return thisSpiritInfo;
	}
	
/*	public void nameSpirit() {

		
		// TODO Auto-generated constructor stub
	}*/
	
	private String[] initialCardList(String mySpirit) {
		String[] startCards;
		switch(mySpirit) {
		case "Bringer of Dreams and Nightmares":
			startCards = new String[]{"ass","butts","bottom","rear"};
			break;
		case "Oceans Hungry Grasp":
			startCards = new String[]{"ass","butts","bottom","rear2"};
			break;
		case "Sharp Fangs Behind the Leaves":
			startCards = new String[]{"ass","butts","bottom","rear3"};
			break;
		case "Keeper of the Forbidden Wilds":
			startCards = new String[]{"ass","butts","bottom","rear4"};
			break;
		default:
			System.out.println("Spirit Not Recognized");
			startCards = new String[]{"oops","oops","wups","ohno"};
		}
		return startCards;
	}
	
}
