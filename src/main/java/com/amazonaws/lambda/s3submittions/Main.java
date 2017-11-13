package com.amazonaws.lambda.s3submittions;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.amazonaws.lambda.s3submittions.pojo.Securities;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	static String offeringLevel = "INSERT INTO OFFERING_LEVEL(OFFER_ID) VALUES(?)";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		validateJSONFile();
		String offeringId = UUID.randomUUID().toString();
		Securities convertJSONToPojo = convertJSONToPojo(Main.class.getResourceAsStream("/create-multiple.json"));
		Connection con = RDSUtil.getRDSConnection();
		try {
			addOfferingLevel(con, convertJSONToPojo, offeringId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void validateJSONFile() {
		JSONObject jsonSchema = new JSONObject(
				new JSONTokener(Main.class.getResourceAsStream("/schema-user-submission.json")));
		JSONObject jsonSubject = new JSONObject(
				new JSONTokener(Main.class.getResourceAsStream("/create-multiple.json")));
		Schema schema = SchemaLoader.load(jsonSchema);
		schema.validate(jsonSubject);
	}

	private static Securities convertJSONToPojo(InputStream is) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(is, Securities.class);
	}

	private static void addOfferingLevel(Connection con, Securities securitues, String offeringId) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(offeringLevel);
		pstmt.setString(1, offeringId);
		pstmt.executeUpdate();
	}

}
