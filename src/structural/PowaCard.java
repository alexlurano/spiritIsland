package structural;

import com.google.gson.annotations.SerializedName;

public class PowaCard extends Card {
int cost;
int range;
String speed;
String source;
String targetType;
String elementsGained;
String cardText;
    

	public PowaCard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String toString() {
		String returnval = "";
		returnval = (cost + " \n " +range + " \n " + speed + " \n " + source + " \n "
		+ targetType + " \n " + elementsGained + " \n " + cardText + " \n "  + cardType
		+ " \n "  + name);
		return returnval;
	}
	
	public String[] toStringArray() {
		String[] returnval = {cost+"",range+"",speed,source,targetType,
				elementsGained,cardText,cardType,name};
		return returnval;
	}



    public String getCardType() {
        return super.cardType;
    }

    public void setCardType(String cardType) {
        super.cardType = cardType;
    }

    public String getName() {
        return super.name;
    }

    public void setName(String name) {
        super.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getElementsGained() {
        return elementsGained;
    }

    public void setElementsGained(String elementsGained) {
        this.elementsGained = elementsGained;
    }

    public String getCardText() {
        return cardText;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }
}