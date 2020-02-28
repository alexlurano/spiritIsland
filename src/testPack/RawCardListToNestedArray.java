package testPack;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RawCardListToNestedArray {
	ArrayList<String> rawCards = new ArrayList<String>();
	ArrayList<ArrayList> cleanCardInfo = new ArrayList<ArrayList>();
	ArrayList<String> dicedCardInfo = new ArrayList<String>();
	
	

	private void printJob(String args) { System.out.println(args); }
	@SuppressWarnings("unchecked")
	private void printArray() {
		ArrayList<String> printArray = new ArrayList<String>();
        for(int i=0; i < cleanCardInfo.size(); i++){
        	printArray = cleanCardInfo.get(i);
            for(int a=0; a < printArray.size(); a++){
            	printJob((printArray.get(a)) );
            }
        }
	}
	public RawCardListToNestedArray() {
		// TODO Auto-generated constructor stub
	}
	
	public void createJsonFile(ArrayList<String> rawCardInfo) {
		rawCards = rawCardInfo;

		beautify(rawCards.get(1),1);
		beautify(rawCards.get(2),2);
//		for(int i=0;i<rawCards.size();i++) {
//			beautify(rawCards.get(i),i);
//		}
	}
	
	private void beautify(String rawInfo,int cardNum) {
		
		String s = rawInfo;
		s = deleteCppRelics(s);
		cleanCardInfo.add(parseOutCommas(s));
		printJob(s);
		printArray();
		
		combineInfoInBrackets();



	}
	
	private String deleteCppRelics(String uglyDuckling) {
		String gorgeousSwan = uglyDuckling;

        gorgeousSwan = gorgeousSwan.replaceAll("[a-zA-Z]*?\\(", ""); // delete cpp class calls
        gorgeousSwan = gorgeousSwan.replaceAll("\\s{2,}", ""); // deletes excessive whitespace
        gorgeousSwan = gorgeousSwan.replaceAll("ProductSet..+?(,.)", "");// deletes ProductSet.whatever and the comma
        gorgeousSwan = gorgeousSwan.replaceAll("PowerDeckType.", ""); //leaves either just minor,major,or spirit
        gorgeousSwan = gorgeousSwan.replaceAll("\"", "");	// gets rid of quotes
        gorgeousSwan = gorgeousSwan.replaceAll("\\)", "");
        gorgeousSwan = gorgeousSwan.replaceAll("new", "");
        gorgeousSwan = gorgeousSwan.replaceAll("\\s{2,}", " ");
        gorgeousSwan = gorgeousSwan.replaceAll("[,]$", ",k"); // so our parser doesnt lose the last element
        	
		return gorgeousSwan;
	}
	
	private ArrayList<String> parseOutCommas(String inputStuff) { // rips apart input until it cant find any more stuff tween commas then returns string "done"

		ArrayList<String> stuffToAdd = new ArrayList<String>();
		String s = inputStuff;
		String regexStatement = ".*?(?=,)."; //matches any number of things up to and including a comma
		Pattern p = Pattern.compile(regexStatement);
		Matcher m = p.matcher(s);
		
		   int commas = 0;
		   for(int i=0;i<s.length();i++)
		   {
			     if(s.charAt(i)==',') 
			    {
			    	 commas++;
			    }
		   }
		while(commas > 0) {
			
			if(m.find())
			{
				String leftToParse = s;
				String myFoundString = m.group();
				//printJob(myFoundString + "found!!!");
				//printJob(s);
				//leftToParse = s.substring(s.lastIndexOf(myFoundString) + myFoundString.length());
				myFoundString = myFoundString.replaceAll(",", "");
				stuffToAdd.add(myFoundString);
				myFoundString = "";
				s = leftToParse;
				//printJob(s);
	
			} else {
				printJob("error!");
			}

			commas--;
		}


		return stuffToAdd;
		
	}
	
	private void combineInfoInBrackets() {
		
	}
}
