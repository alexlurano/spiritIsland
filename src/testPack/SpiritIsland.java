package testPack;


public class SpiritIsland {


    
    
	public SpiritIsland() {
		// TODO Auto-generated constructor stub
	}
	



	public static void main(String[] args) {
		// initialize invaders
		//XmlControl storageUnit = new XmlControl();
		//storageUnit.doStuff();
		

		CardListParser makeCleanInfo = new CardListParser();
		makeCleanInfo.accessInfoFromGermans();
		
		GameContainer objectToHoldall = new GameContainer();
		objectToHoldall.doStuff();
	}
	

	
	public void sendInfoToXml() {

	}

}
