
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
 * User Submission
 * <p>
 * Offering Activity User Submission
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "source",
    "sourceId",
    "sbmtrId",
    "offering",
    "issues"
})
public class Securities {

    /**
     * manual, automatic
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("manual, automatic")
    private String type;
    /**
     * external, internal
     * (Required)
     * 
     */
    @JsonProperty("source")
    @JsonPropertyDescription("external, internal")
    private String source;
    /**
     * submitter's firm id
     * (Required)
     * 
     */
    @JsonProperty("sourceId")
    @JsonPropertyDescription("submitter's firm id")
    private String sourceId;
    /**
     * submitter's email id
     * (Required)
     * 
     */
    @JsonProperty("sbmtrId")
    @JsonPropertyDescription("submitter's email id")
    private String sbmtrId;
    @JsonProperty("offering")
    private Offering offering;
    /**
     * Set of Issues
     * 
     */
    @JsonProperty("issues")
    @JsonPropertyDescription("Set of Issues")
    private List<Issue> issues = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * manual, automatic
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * manual, automatic
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * external, internal
     * (Required)
     * 
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * external, internal
     * (Required)
     * 
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * submitter's firm id
     * (Required)
     * 
     */
    @JsonProperty("sourceId")
    public String getSourceId() {
        return sourceId;
    }

    /**
     * submitter's firm id
     * (Required)
     * 
     */
    @JsonProperty("sourceId")
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * submitter's email id
     * (Required)
     * 
     */
    @JsonProperty("sbmtrId")
    public String getSbmtrId() {
        return sbmtrId;
    }

    /**
     * submitter's email id
     * (Required)
     * 
     */
    @JsonProperty("sbmtrId")
    public void setSbmtrId(String sbmtrId) {
        this.sbmtrId = sbmtrId;
    }

    @JsonProperty("offering")
    public Offering getOffering() {
        return offering;
    }

    @JsonProperty("offering")
    public void setOffering(Offering offering) {
        this.offering = offering;
    }

    /**
     * Set of Issues
     * 
     */
    @JsonProperty("issues")
    public List<Issue> getIssues() {
        return issues;
    }

    /**
     * Set of Issues
     * 
     */
    @JsonProperty("issues")
    public void setIssues(List<Issue> issues) {
        this.issues = issues;
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
