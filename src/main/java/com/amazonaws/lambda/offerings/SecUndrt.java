
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


/**
 * Security Underwriter
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "undrtId",
    "takedown"
})
public class SecUndrt {

    /**
     * create, modify, delete
     * (Required)
     * 
     */
    @JsonProperty("action")
    @JsonPropertyDescription("create, modify, delete")
    private String action;
    /**
     * Underwriter Id
     * 
     */
    @JsonProperty("undrtId")
    @JsonPropertyDescription("Underwriter Id")
    private String undrtId;
    /**
     * Takedown Amount
     * 
     */
    @JsonProperty("takedown")
    @JsonPropertyDescription("Takedown Amount")
    private Integer takedown;
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
     * Underwriter Id
     * 
     */
    @JsonProperty("undrtId")
    public String getUndrtId() {
        return undrtId;
    }

    /**
     * Underwriter Id
     * 
     */
    @JsonProperty("undrtId")
    public void setUndrtId(String undrtId) {
        this.undrtId = undrtId;
    }

    /**
     * Takedown Amount
     * 
     */
    @JsonProperty("takedown")
    public Integer getTakedown() {
        return takedown;
    }

    /**
     * Takedown Amount
     * 
     */
    @JsonProperty("takedown")
    public void setTakedown(Integer takedown) {
        this.takedown = takedown;
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
