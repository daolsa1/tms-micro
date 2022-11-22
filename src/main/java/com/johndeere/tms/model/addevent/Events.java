package com.johndeere.tms.model.addevent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Events {

    @JsonProperty("eventAt")
    private String eventAt;

    @JsonProperty("eventType")
    private String eventType;

    @JsonProperty("payload")
    private String payload;

    public Events(String eventAt, String eventType, String payload){
        this.eventAt = eventAt;
        this.eventType = eventType;
        this.payload = payload;
    }

}
