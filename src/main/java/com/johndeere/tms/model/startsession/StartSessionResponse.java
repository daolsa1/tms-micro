package com.johndeere.tms.model.startsession;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StartSessionResponse {

    @JsonProperty("sessionId")
    private String sessionId;

    public StartSessionResponse(){}

    public StartSessionResponse(String sessionId){
        this.sessionId = sessionId;
    }
}
