
package com.amazonaws.lambda.s3submittions.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Issue
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "issueId",
    "baseQsip",
    "xpctdClsgDt",
    "securities"
})
public class Issue {

    /**
     * create, modify, delete
     * (Required)
     * 
     */
    @JsonProperty("action")
    @JsonPropertyDescription("create, modify, delete")
    private String action;
    /**
     * DTC Offering Issue Id
     * 
     */
    @JsonProperty("issueId")
    @JsonPropertyDescription("DTC Offering Issue Id")
    private String issueId;
    /**
     * Base CUSIP
     * 
     */
    @JsonProperty("baseQsip")
    @JsonPropertyDescription("Base CUSIP")
    private String baseQsip;
    /**
     * Expected Closing Date
     * 
     */
    @JsonProperty("xpctdClsgDt")
    @JsonPropertyDescription("Expected Closing Date")
    private String xpctdClsgDt;
    /**
     * Set of Securities
     * 
     */
    @JsonProperty("securities")
    @JsonPropertyDescription("Set of Securities")
    private List<Security> securities = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * create, modify, delete
     * (Required)
     * 
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * create, modify, delete
     * (Required)
     * 
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * DTC Offering Issue Id
     * 
     */
    @JsonProperty("issueId")
    public String getIssueId() {
        return issueId;
    }

    /**
     * DTC Offering Issue Id
     * 
     */
    @JsonProperty("issueId")
    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    /**
     * Base CUSIP
     * 
     */
    @JsonProperty("baseQsip")
    public String getBaseQsip() {
        return baseQsip;
    }

    /**
     * Base CUSIP
     * 
     */
    @JsonProperty("baseQsip")
    public void setBaseQsip(String baseQsip) {
        this.baseQsip = baseQsip;
    }

    /**
     * Expected Closing Date
     * 
     */
    @JsonProperty("xpctdClsgDt")
    public String getXpctdClsgDt() {
        return xpctdClsgDt;
    }

    /**
     * Expected Closing Date
     * 
     */
    @JsonProperty("xpctdClsgDt")
    public void setXpctdClsgDt(String xpctdClsgDt) {
        this.xpctdClsgDt = xpctdClsgDt;
    }

    /**
     * Set of Securities
     * 
     */
    @JsonProperty("securities")
    public List<Security> getSecurities() {
        return securities;
    }

    /**
     * Set of Securities
     * 
     */
    @JsonProperty("securities")
    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
