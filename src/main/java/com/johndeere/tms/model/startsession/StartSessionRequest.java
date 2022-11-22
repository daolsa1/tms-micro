package com.johndeere.tms.model.startsession;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StartSessionRequest {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("machineId")
    private String machineId;

    @JsonProperty("startAt")
    private String startAt;

    @JsonProperty("orgId")
    private Integer orgId;
}