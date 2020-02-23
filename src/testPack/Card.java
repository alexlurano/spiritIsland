package testPack;

public class Card {
	
	Boolean isForgotten = false;
	String cardType; 
	String cardName; // cardname would be lands being targeted for invader cards

	public Card(String typeOfCard, String nameOfCard) {
		
		cardType = typeOfCard;
		cardName = nameOfCard;
		//System.out.println(cardType + " Created!");
	}
	
	public void forgetCard() {
		isForgotten = true; // toDo wrap regular discarding into this function or create new method.
	}
	
	public String toString() {
		return("This card is a(n) " + cardType + " it is called " + cardName); 
	}

}
