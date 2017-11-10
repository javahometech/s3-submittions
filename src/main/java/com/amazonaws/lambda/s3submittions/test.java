package com.amazonaws.lambda.s3submittions;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
import java.util.Iterator;

public class test {
	 public static void main(String[] args) throws SQLException {

		 String dbURL  = "jdbc:mysql://admin.ct2n3gpfnz9q.ap-south-1.rds.amazonaws.com:3306/Javahome";
 		String dbUser = "admin"; 
 		String dbPass = "adminadmin";
 		Connection conn = null; 
		 
	        JSONParser parser = new JSONParser();

	        try {

	            Object obj = parser.parse(new FileReader("C:\\Users\\Yash\\Desktop\\create-multiple.json"));

	            JSONObject jsonObject = (JSONObject) obj;
                    

	            
	            JSONArray slideContent = (JSONArray) jsonObject.get("issues");
	            Iterator i = slideContent.iterator();
	            
	            
	            while (i.hasNext()) {
	               
	            	JSONObject slide = (JSONObject) i.next();
	                String name = (String)slide.get("baseQsip");
	                
	              
	           		String sql = "insert into test(baseQsip) values (?)";	 
	        		PreparedStatement statement = conn.prepareStatement(sql);
	        		
	        		statement.setString(1,name);
	        		
	        		
	        		int row = statement.executeUpdate();
	        		if (row > 0) {
	        		    System.out.println("success");
	        		    
	        		    }
	 
	                
	                
	            }
	            
	            

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	    }

}
