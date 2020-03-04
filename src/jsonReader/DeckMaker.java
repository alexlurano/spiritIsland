package jsonReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DeckMaker {

	String fileName;
	public DeckMaker() {
	}
	
	private void printJob(String args) {System.out.println(args);}
	public JsonArray openJson(String infoType) {
		/* infotype references one of the included json files created by project
		 * CardDataCleaner
		 * todo: seperate minor and major powers
		 * create jsons for fear cards and events.
		 * 
		 * 
		 */
		switch (infoType) {
			case "start":
				fileName = "startCards.json";
				break;
			case "minor":
				fileName = "MinorPowers.json";
				break;
			case "major":
				fileName = "MajorPowers.json";
				break;
			case "Event":
				fileName = "";
				break;
			case "Fear":
				fileName = "";
				break;
			default:
				fileName = "";
		}
		
		if(fileName.isEmpty()) {
			printJob("request denied: " + infoType + "is not a correct filetype.");
			return new JsonArray();
		}
		
		return jsonInterpereter(); // attempt to open the file requested;
		
		
	}
	
	private JsonArray jsonInterpereter(){
        fileName = "src/data/" + fileName;
        
        Path path = Paths.get(fileName);

        try (Reader reader = Files.newBufferedReader(path,
            StandardCharsets.UTF_8)) {

            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);
            JsonArray array = tree.getAsJsonArray();
            
            return array;

        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new JsonArray();
	}

}
