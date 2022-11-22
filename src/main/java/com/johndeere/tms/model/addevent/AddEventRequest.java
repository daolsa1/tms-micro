package com.johndeere.tms.model.addevent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddEventRequest {

    @JsonProperty("sessionId")
    private String sessionId;

    @JsonProperty("events")
    private List<Events> events;
}