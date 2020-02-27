package testPack;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RawToJsonParser {
	ArrayList<String> rawCards = new ArrayList<String>();
	
	
	

	private void printJob(String args) { System.out.println(args); }
	public RawToJsonParser() {
		// TODO Auto-generated constructor stub
	}
	
	public void createJsonFile(ArrayList<String> rawCardInfo) {
		rawCards = rawCardInfo;

		beautify(rawCards.get(1),1);
//		for(int i=0;i<rawCards.size();i++) {
//			beautify(rawCards.get(i),i);
//		}
	}
	
	private void beautify(String rawInfo,int cardNum) {
		ArrayList<String> dicedCardInfo = new ArrayList<String>();
		String regexStatement = "PowerCard";
	String s = rawInfo.substring(rawInfo.lastIndexOf(regexStatement) + regexStatement.length());
	printJob(s);
	regexStatement = ".*?(?=,)";
	Pattern p = Pattern.compile(regexStatement);
	Matcher m = p.matcher(s);
	if(m.find())
	{
		String myFoundString = m.group();
		printJob(myFoundString);
		dicedCardInfo.add(myFoundString);
		s = s.substring(s.lastIndexOf(myFoundString) + myFoundString.length()+1);
		s = s.strip();
		printJob(s);
	}
//		String mything = rawInfo;
//		Pattern p = Pattern.compile("\\s.PowerCard");
//		Matcher m = p.matcher(mything);
//		if(m.find()) {
//			String theGroup = m.group();
//			mything = m.replaceAll("Done");
//			printJob(mything);
//			printJob(theGroup);
//		}
	}
}
