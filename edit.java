package com.mkyong.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class edit {static ArrayList<String[]> list;	
static ArrayList<String> arrayll;
static String currentSource;
static int count = 0;
static int countStation= 0;
public static void main(String[] args) throws IOException, FileNotFoundException, IOException {
edit obj = new edit();
currentSource = new String();


  
list = new ArrayList<String[]>();
arrayll = new ArrayList<String>();
obj.run();
int i = 0;
for (int j = 1; j<list.size();j++){
	i = j;
	String source = list.get(j)[1];
	System.out.println("j: " + list.get(j)[1]);
	while(i<list.size()){
		if (i+1 == list.size() || list.get(i+1).length<3)
			break;
		String dest = list.get(i)[2];
			if (dest == null || dest.trim().length() == 0){
				dest = list.get(i+1)[2];
			}
		i = process(j,dest);
	}
	count = 0;
	while (list.get(j).length<2){
		j++;
	}
	while (j<list.size() && list.get(j)[1].equals(source)){
		j++;
		}
	
	j= j-1;
	
	
	}
}

public static int process(int source,String dest) throws IOException, FileNotFoundException, IOException{
  count++;
  int i = source;
  String ans = "";
  if (!list.get(source)[1].trim().equals(currentSource)){
  	ans = "}\n{ \"" + list.get(source)[1]+ "\"" + " : \n \t" + " { " ;
  	currentSource = list.get(source)[1];
  }
  String path = "";
  if (i>=list.size())
	  System.out.println(i);
  while (!list.get(i)[1].equals(dest)){
	 path += callString(list.get(i)[3],list.get(i)[4])+ " , \n";
	 i++;
  }
  ans +=  "\"" + list.get(i-1)[2] + "\"" 
		  + " : [ \n" + path  + callString(list.get(i)[3],list.get(i)[4])+ "],\n";
  arrayll.add(ans);
  
  System.out.print("|| " + count  + " "  + list.get(i)[1] + "\n" );
  
  return i;
}
public static String callString(String temp1, String temp2){
return "\t \t {\"lat\": " + temp1 + ", \"lng\":" + temp2 + "}";
}
public static void print (String[] country){
  System.out.println("Country [code= " + country[0] 
          + " , From=" + country[1] + "]"
          + " , To=" + country[2] + "]"
          + " , Lat=" + country[3] + "]"
          + " , Long=" + country[4] + "]"
          + " , time=" + country[4] + "]");

}
public void run() {
String csvFile = "C:/Users/lcttnguyen/workspace/edit/src/CC(to Dhoby).json";
BufferedReader br = null;
String line = "";
String cvsSplitBy = ",|:";

try {
	int count = 2;
	br = new BufferedReader(new FileReader(csvFile));
	while ((line = br.readLine()) != null) {
		String country = line;
		if (count%2==0 ){
	        // use comma as separator
			if (country!=null)
				System.out.println(country);
				//list.add(country);
		}
		count++;
	}

} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
} finally {
	if (br != null) {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
}

}