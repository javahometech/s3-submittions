
package com.amazonaws.lambda.offerings;

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
 * Security
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "secId",
    "maturityDt",
    "datedDt",
    "intRt",
    "secUndrt"
})
public class Security {

    /**
     * create, modify, delete
     * (Required)
     * 
     */
    @JsonProperty("action")
    @JsonPropertyDescription("create, modify, delete")
    private String action;
    /**
     * DTC Offering Security Id
     * 
     */
    @JsonProperty("secId")
    @JsonPropertyDescription("DTC Offering Security Id")
    private String secId;
    /**
     * Maturity Date
     * 
     */
    @JsonProperty("maturityDt")
    @JsonPropertyDescription("Maturity Date")
    private String maturityDt;
    /**
     * Dated Date
     * 
     */
    @JsonProperty("datedDt")
    @JsonPropertyDescription("Dated Date")
    private String datedDt;
    /**
     * Interest Rate
     * 
     */
    @JsonProperty("intRt")
    @JsonPropertyDescription("Interest Rate")
    private Double intRt;
    /**
     * Set of Security Underwriters
     * 
     */
    @JsonProperty("secUndrt")
    @JsonPropertyDescription("Set of Security Underwriters")
    private List<SecUndrt> secUndrt = null;
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
     * DTC Offering Security Id
     * 
     */
    @JsonProperty("secId")
    public String getSecId() {
        return secId;
    }

    /**
     * DTC Offering Security Id
     * 
     */
    @JsonProperty("secId")
    public void setSecId(String secId) {
        this.secId = secId;
    }

    /**
     * Maturity Date
     * 
     */
    @JsonProperty("maturityDt")
    public String getMaturityDt() {
        return maturityDt;
    }

    /**
     * Maturity Date
     * 
     */
    @JsonProperty("maturityDt")
    public void setMaturityDt(String maturityDt) {
        this.maturityDt = maturityDt;
    }

    /**
     * Dated Date
     * 
     */
    @JsonProperty("datedDt")
    public String getDatedDt() {
        return datedDt;
    }

    /**
     * Dated Date
     * 
     */
    @JsonProperty("datedDt")
    public void setDatedDt(String datedDt) {
        this.datedDt = datedDt;
    }

    /**
     * Interest Rate
     * 
     */
    @JsonProperty("intRt")
    public Double getIntRt() {
        return intRt;
    }

    /**
     * Interest Rate
     * 
     */
    @JsonProperty("intRt")
    public void setIntRt(Double intRt) {
        this.intRt = intRt;
    }

    /**
     * Set of Security Underwriters
     * 
     */
    @JsonProperty("secUndrt")
    public List<SecUndrt> getSecUndrt() {
        return secUndrt;
    }

    /**
     * Set of Security Underwriters
     * 
     */
    @JsonProperty("secUndrt")
    public void setSecUndrt(List<SecUndrt> secUndrt) {
        this.secUndrt = secUndrt;
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
