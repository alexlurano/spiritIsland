package testPack;


public class SpiritIsland {


    
    
	public SpiritIsland() {
		// TODO Auto-generated constructor stub
	}
	



	public static void main(String[] args) {
		// initialize invaders
		//XmlControl storageUnit = new XmlControl();
		//storageUnit.doStuff();
		

		RawCardListCreator makeCleanInfo = new RawCardListCreator();
		makeCleanInfo.accessInfoFromGermans();
		
		RawToJsonParser makeInfoPretty = new RawToJsonParser();
		makeInfoPretty.createJsonFile(makeCleanInfo.getCardArray());
		
		GameContainer objectToHoldall = new GameContainer();
		objectToHoldall.doStuff();
	}
	

	
	public void sendInfoToXml() {

	}

}
