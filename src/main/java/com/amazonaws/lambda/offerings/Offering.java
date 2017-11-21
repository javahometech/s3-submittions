
package com.amazonaws.lambda.offerings;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "ofrngId",
    "legalDs"
})
public class Offering {

    /**
     * create, modify, delete
     * (Required)
     * 
     */
    @JsonProperty("action")
    @JsonPropertyDescription("create, modify, delete")
    private String action;
    /**
     * DTC Offering Id
     * 
     */
    @JsonProperty("ofrngId")
    @JsonPropertyDescription("DTC Offering Id")
    private String ofrngId;
    /**
     * Legal Description
     * 
     */
    @JsonProperty("legalDs")
    @JsonPropertyDescription("Legal Description")
    private String legalDs;
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
     * DTC Offering Id
     * 
     */
    @JsonProperty("ofrngId")
    public String getOfrngId() {
        return ofrngId;
    }

    /**
     * DTC Offering Id
     * 
     */
    @JsonProperty("ofrngId")
    public void setOfrngId(String ofrngId) {
        this.ofrngId = ofrngId;
    }

    /**
     * Legal Description
     * 
     */
    @JsonProperty("legalDs")
    public String getLegalDs() {
        return legalDs;
    }

    /**
     * Legal Description
     * 
     */
    @JsonProperty("legalDs")
    public void setLegalDs(String legalDs) {
        this.legalDs = legalDs;
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
