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

public class convertor {

  public static void main(String[] args) throws IOException {

	convertor obj = new convertor();
	
	Writer writer = null;
	try {
	    writer = new BufferedWriter(new OutputStreamWriter(
	          new FileOutputStream("yellow(dhoby-marina bay).csv")));
	    obj.run(writer);
	}finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
	}

  }
  public static String print (String[] country){
	 if (country[2]==null|| country[2].trim().length()<1)
		 return country[0]+ ","  + country[1] + ": ," + country[3] + ","+ country[4] + ","
				 + ",,,,,\n";
	 
	 return country[0]+ "," + country[2]+ ":" + country[1] + "," + country[3] + ","+ country[4] + ","
			 + ",,,,,\n";
	
  }

  public void run(Writer writer) {

	String csvFile = "C:/Users/lcttnguyen/workspace/convert/src/yellow(dhoby-marina bay).csv";
	BufferedReader br = null;
	String line = "";
	ArrayList<String> array = new ArrayList<String>();
	String cvsSplitBy = ",|:";
	try {
		int count = 2;
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
			String[] country = line.split(cvsSplitBy);
			if (count%2==0 ){
		        // use comma as separator]
				array.add(print(country));					
			} else {
				array.add("\n");
			}
			count++;
		}
	for (int i = array.size()-1 ; i>=0; i--){
		writer.write(array.get(i));
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

	System.out.println("Done");
  }

}
