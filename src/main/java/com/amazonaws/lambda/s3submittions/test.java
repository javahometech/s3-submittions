package com.amazonaws.lambda.s3submittions;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
/*import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
*/

import java.util.Iterator; 

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.JSONParser; 




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {
	 public static void main(String[] args) throws SQLException {

	
	
	 
	//            Object obj = parser.parse(new FileReader("C:\\Users\\Yash\\git\\s3-submittions\\src\\main\\resources\\create-multiple.json"));
String file="C:\\Users\\Yash\\git\\s3-submittions\\src\\main\\resources\\create-multiple.json";
		 JSONParser parser = new JSONParser();
		 try { 
			 System.out.println("Reading JSON file from Java program"); 
		 FileReader fileReader = new FileReader(file);
		 JSONObject json = (JSONObject) parser.parse(fileReader);
		 String title = (String) json.get("type");
		 System.out.println("title: " + title);
		 
		 JSONObject jsonObject = (JSONObject) json;
         JSONArray slideContent = (JSONArray) jsonObject.get("issues");
         Iterator i1 = slideContent.iterator();
         
         
         while (i1.hasNext()) {
            
         	JSONObject slide = (JSONObject) i1.next();
             String name = (String)slide.get("baseQsip");
             System.out.println(name);
         }
		 
		 
		 
		 JSONArray characters = (JSONArray) json.get("issues"); 
		 Iterator i = characters.iterator(); 
		 System.out.println("characters: ");
		
		 while (i.hasNext()) 
		 { 
			 System.out.println(" " + i.next()); 
			 

         
		 }

		
		 
		 
		 }
		 catch (Exception ex) { ex.printStackTrace(); }

		         
	 
	 
	 }}
