package com.amazonaws.lambda.s3submittions;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;


public class ValidateJSONTest {
//	@Test
	public void givenInvalidInput_whenValidating_thenInvalid() throws ValidationException {
	    JSONObject jsonSchema = new JSONObject(
	      new JSONTokener(ValidateJSONTest.class.getResourceAsStream("/schema.json")));
	    JSONObject jsonSubject = new JSONObject(
	      new JSONTokener(ValidateJSONTest.class.getResourceAsStream("/data.json")));
	     
	    Schema schema = SchemaLoader.load(jsonSchema);
	    
	    schema.validate(jsonSubject);
	}
	
	@Test
	public void givenValidInput_whenValidating_thenValid() throws ValidationException {
	    JSONObject jsonSchema = new JSONObject(
	      new JSONTokener(ValidateJSONTest.class.getResourceAsStream("/schema-user-submission.json")));
	    JSONObject jsonSubject = new JSONObject(
	      new JSONTokener(ValidateJSONTest.class.getResourceAsStream("/create-multiple.json")));
	 
	    Schema schema = SchemaLoader.load(jsonSchema);
	    schema.validate(jsonSubject);
	}
}
