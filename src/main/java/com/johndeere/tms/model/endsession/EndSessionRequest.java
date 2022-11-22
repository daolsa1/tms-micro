package com.johndeere.tms.model.endsession;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EndSessionRequest {

    @JsonProperty("sessionId")
    private String sessionId;

    @JsonProperty("endAt")
    private String endAt;
}
