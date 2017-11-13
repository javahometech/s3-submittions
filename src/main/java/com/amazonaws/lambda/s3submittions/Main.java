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
	static String offeringLevel = "INSERT INTO OFFERING_LEVEL(OFFERING_ID, ACTION, LEGALDS) VALUES(?, ?, ?)";
	static String issuesLevel = "INSERT INTO ISSUES_LEVEL(OFFERING_ID, ACTION, BASE_QSIP, XPCTD_CLSG_DT) VALUES(?, ?, ?, ?)";
	static String issuesSecuritiesLevel = "INSERT INTO ISSUES_SECURITIES_LEVEL(OFFERING_ID, ACTION, SECID, MATURITYDT, DATEDDT, INTRT) VALUES(?, ?, ?, ?, ?, ?)";
	static String issuesSecUndrtLevel = "INSERT INTO ISSUES_SECUNDRT_LEVEL(OFFERING_ID, ACTION, UNDRTID, TAKEDOWN) VALUES(?, ?, ?, ?)";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		validateJSONFile();
		String offeringId = UUID.randomUUID().toString();
		Securities convertJSONToPojo = convertJSONToPojo(Main.class.getResourceAsStream("/create-multiple.json"));
		Connection con = RDSUtil.getRDSConnection();
		try {
			addOfferingLevel(con, convertJSONToPojo, offeringId);
			addIssuesLevel(con, convertJSONToPojo, offeringId);
			addIssuesSecuritiesLevel(con, convertJSONToPojo, offeringId);
			addIssuesSecUndrtLevel(con, convertJSONToPojo, offeringId);
			System.out.println("SUCCESS");
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
		pstmt.setString(2, securitues.getOffering().getAction());
		pstmt.setString(3, securitues.getOffering().getLegalDs());
		pstmt.executeUpdate();
	}
	
	private static void addIssuesLevel(Connection con, Securities securitues, String offeringId) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(issuesLevel);
		pstmt.setString(1, offeringId);
		pstmt.setString(2, securitues.getIssues().get(0).getAction());
		pstmt.setString(3, securitues.getIssues().get(0).getBaseQsip());
		pstmt.setString(4, securitues.getIssues().get(0).getXpctdClsgDt());
		pstmt.executeUpdate();
	}
	
	private static void addIssuesSecuritiesLevel(Connection con, Securities securitues, String offeringId) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(issuesSecuritiesLevel);
		pstmt.setString(1, offeringId);
		pstmt.setString(2, securitues.getIssues().get(0).getSecurities().get(0).getAction());
		pstmt.setString(3, securitues.getIssues().get(0).getSecurities().get(0).getSecId());
		pstmt.setString(4, securitues.getIssues().get(0).getSecurities().get(0).getMaturityDt());
		pstmt.setString(5, securitues.getIssues().get(0).getSecurities().get(0).getDatedDt());
		pstmt.setDouble(6, securitues.getIssues().get(0).getSecurities().get(0).getIntRt());
		pstmt.executeUpdate();
	}
	
	private static void addIssuesSecUndrtLevel(Connection con, Securities securitues, String offeringId) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(issuesSecUndrtLevel);
		pstmt.setString(1, offeringId);
		pstmt.setString(2, securitues.getIssues().get(0).getSecurities().get(0).getSecUndrt().get(0).getAction());
		pstmt.setDouble(3, securitues.getIssues().get(0).getSecurities().get(0).getSecUndrt().get(0).getUndrtId());
		pstmt.setDouble(4, securitues.getIssues().get(0).getSecurities().get(0).getSecUndrt().get(0).getTakedown());
		pstmt.executeUpdate();
	}

}
