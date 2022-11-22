package com.johndeere.tms.model.getevents;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.johndeere.tms.model.addevent.Events;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetEventsResponse {

    @JsonProperty("events")
    private List<Events> events;
}
