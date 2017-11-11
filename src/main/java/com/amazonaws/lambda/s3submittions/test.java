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
		 String dbURL  = "jdbc:mysql://admin.ct2n3gpfnz9q.ap-south-1.rds.amazonaws.com:3306/Javahome";
	 		String dbUser = "admin"; 
	 		String dbPass = "adminadmin";
	 		Connection conn = null; 
		
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

			Random r=new Random();
	
	 
	//            Object obj = parser.parse(new FileReader("C:\\Users\\Yash\\git\\s3-submittions\\src\\main\\resources\\create-multiple.json"));
String file="C:\\Users\\Yash\\git\\s3-submittions\\src\\main\\resources\\create-multiple.json";
		 JSONParser parser = new JSONParser();
		 try { 
		 
		 FileReader fileReader = new FileReader(file);
		 JSONObject json = (JSONObject) parser.parse(fileReader);
		 String title = (String) json.get("type");
		 System.out.println("type: " + title);
		 
		 JSONObject jsonObject = (JSONObject) json;
         JSONArray slideContent = (JSONArray) jsonObject.get("issues");
         Iterator i1 = slideContent.iterator();
         
         
         while (i1.hasNext()) {
            
         	JSONObject slide = (JSONObject) i1.next();
             String baseQsip = (String)slide.get("baseQsip");
             /*Generating random number for offering_id*/
             String offering_id_generate=r.nextSessionId();
     		String sql = "insert into demo(offering_id,baseQsip) values (?,?)";	 
    		PreparedStatement statement = conn.prepareStatement(sql);
    		
    		statement.setString(1,baseQsip);
    		statement.setString(2,offering_id_generate);
    		
    		
    		int row = statement.executeUpdate();
    		if (row > 0) {
    		    System.out.println(" saved");
    		    
    		    }

             
             
         }
		 
         
/*         JSONObject o=(JSONObject)jsonObject.get("offering");
         
         String offering_name = (String)o.get("legalDs");
         
         System.out.println(offering_name);
*/          
      
         
/*         JSONArray Main_issues = (JSONArray) jsonObject.get("issues"); 
         for (int i = 0; i < Main_issues.size(); i++) {
             
             JSONArray sec_array = (JSONArray) new JSONArray().get(i);
             System.out.println("====================///////////"+sec_array);

             for (int j = 0; j < sec_array.size(); j++) {
            	    String secId = (String) sec_array.get(0);
            	    System.out.println("Secid" + secId);
            	}}
         
         */
         
         
		 
		 }
		 catch (Exception ex) { ex.printStackTrace(); }

		         
	 
	 
	 }}
