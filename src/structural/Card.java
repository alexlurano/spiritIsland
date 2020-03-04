package structural;

public class Card {
	
	Boolean isForgotten = false;
	String cardType; 
	String name; // cardname would be lands being targeted for invader cards

	public Card() {
		
		//System.out.println(cardType + " Created!");
	}
	
	public void forgetCard() {
		isForgotten = true; // toDo wrap regular discarding into this function or create new method.
	}
	
	public String toString() {
		return("This card is a(n) " + cardType + " it is called " + name); 
	}
	
	public String getname() {
		return name;
	}

	public Boolean getIsForgotten() {
		return isForgotten;
	}

	public void setIsForgotten(Boolean isForgotten) {
		this.isForgotten = isForgotten;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	
}
