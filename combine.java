package combine;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class JsonSimpleExample {
     public static void main(String[] args) throws org.json.simple.parser.ParseException, ParseException {
    String output = "";
	JSONObject obj = new JSONObject();
	JSONParser parser = new JSONParser();
    ArrayList<Object> read = new ArrayList<Object>();
    ArrayList<JSONObject> files = new ArrayList<JSONObject>();
    String key = "j: Changi Airportj: Expoj: Bugisj: Promenadej: Bayfrontj: Downtownj: Telok Ayerj: Chinatownj: Jurong Eastj: Bukit Batokj: Bukit Gombakj: Choa Chu Kangj: Yew Teej: Kranjij: Marsilingj: Woodlandsj: Admiraltyj: Sembawangj: Yishunj: Khatibj: Yio Chu Kangj: Ang Mo Kioj: Bishanj: Braddellj: Toa Payohj: Novenaj: Newtonj: Orchardj: Somersetj: Dhoby Ghautj: City Hallj: Raffles Placej: Marina Bayj: Pasir Risj: Tampinesj: Simeij: Tanah Merahj: Bedokj: Kembanganj: Eunosj: Paya Lebarj: Aljuniedj: Kallangj: Lavenderj: Bugisj: City Hallj: Raffles Placej: Tanjong Pagarj: Outram Parkj: Tiong Bahruj: Redhillj: Queenstownj: Commonwealthj: Buona Vistaj: Doverj: Clementij: Jurong Eastj: Chinese Gardenj: Lakesidej: Boon Layj: Pioneerj: Joo Koonj: Dhoby Ghautj: Bras Basahj: Esplanadej: Promenadej: Nicoll Highwayj: Stadiumj: Mountbattenj: Dakotaj: Paya Lebarj: MacPhersonj: Tai Sengj: Bartleyj: Serangoonj: Lorong Chuanj: Bishanj: Marymountj: Caldecottj: Botanic Gardensj: Farrer Roadj: Holland Villagej: Buona Vistaj: one-northj: Kent Ridgej: Haw Par Villaj: Pasir Panjangj: Labrador Parkj: Telok Blangahj: HarbourFrontj: Punggolj: Sengkangj: Buangkokj: Hougangj: Kovanj: Serangoonj: Woodleighj: Potong Pasirj: Boon Kengj: Farrer Parkj: Little Indiaj: Dhoby Ghautj: Clarke Quayj: Chinatownj: Outram Parkj: HarbourFrontj:";
    String[] searchKey = key.split("j:");
    JSONObject system = new JSONObject();
    
	 try {
		 //Read in each file to and array of files
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files/DT(Bugis).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files/DT(Chinatown).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files/yellow(HabourFront - Marina Bay).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files/yellow(Habour front - Dhoby).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files/NS(Marinay Bay - JE).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files/NE(Habourfront).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files/EW(JK-PR).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files/EW(JK - Changi).json")));
         
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files2/greenline(Changi - JK).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files2/greenline(Changi-Pasir Ris).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files2/greenline(Pasir Ris - JK).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files2/greenline(PasirRis- Changi).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files2/purpleline(punggol-Habourfront).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files2/red(JE-Marina Bay).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files2/yellow(Dhoby-Habourfront).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files2/yellow(dhoby-marina bay).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files2/yellow(Marina Bay - Dhoby).json")));
         read.add(parser.parse(new FileReader("C:/Users/lcttnguyen/workspace/combine/files2/yellow(marina-habourfront).json")));
         
         
         
         
         
    
         
         for (int i =0; i< read.size();i ++){
        	 files.add((JSONObject) read.get(i));
         }
         for (int i = 1; i<searchKey.length;i++){
        	 JSONObject oneStation = new JSONObject();
        	 String stationName = searchKey[i].trim();
        	 for (int j = 0; j< files.size();j++){
        		 oneStation = merge(oneStation, (JSONObject) files.get(j).get(stationName.trim()));
        	 }
        	// System.out.println(i+ " name: "+ stationName + " || Num: " + oneStation.size());
        	 system.put(stationName, oneStation);
        	 //System.out.println(oneStation.keySet());
         }
         	
    	  writeTo(system.toJSONString());
         
         // loop array
        
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
	Scanner sc = new Scanner(System.in);
	String cmd=sc.nextLine();
	while (cmd!="-1"){
		cmd = cmd.trim();
		System.out.println();
		System.out.println(((JSONObject) system.get(cmd)));
		System.out.print(((JSONObject) system.get(cmd)).keySet());
		cmd = sc.nextLine();
	}
     }
    public static   JSONObject merge(JSONObject json1, JSONObject json2){
    	JSONObject mergedJSON = new JSONObject();
    		if (!json1.isEmpty()){
    		String[] array1 = (String[]) json1.keySet().toArray(new String[json1.size()]);
    		for (int i = 0 ;i <array1.length;i ++){
    			if (!mergedJSON.containsKey(array1[i]))
    					mergedJSON.put(array1[i], json1.get(array1[i]));
    		}
    		}
    		if (json2!= null && !json2.isEmpty()){
    		String[] array2 =(String[]) json2.keySet().toArray(new String[json2.size()]);
	    		for (int i = 0 ;i <array2.length;i ++){
	    			if (!mergedJSON.containsKey(array2[i]))
	    					mergedJSON.put(array2[i], json2.get(array2[i]));
	    		}
    		}
    		return mergedJSON;
    }

	private static void writeTo(String output) {
		try {

			FileWriter file = new FileWriter("C:/Users/lcttnguyen/workspace/combine/test.json",true);
			file.write(output);
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}