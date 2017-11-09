package com.amazonaws.lambda.s3submittions;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Main {
	public static void main(String[] args)  {
		 JSONObject jsonSchema = new JSONObject(
			      new JSONTokener(Main.class.getResourceAsStream("/schema-user-submission.json")));
			    JSONObject jsonSubject = new JSONObject(
			      new JSONTokener(Main.class.getResourceAsStream("/create-multiple.json")));
			 
			    Schema schema = SchemaLoader.load(jsonSchema);
			    schema.validate(jsonSubject);
			    System.out.println("Success");
	}
}
