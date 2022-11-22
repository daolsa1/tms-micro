package com.johndeere.tms.controller;

import com.johndeere.tms.model.addevent.AddEventRequest;
import com.johndeere.tms.model.addevent.Events;
import com.johndeere.tms.model.endsession.EndSessionRequest;
import com.johndeere.tms.model.startsession.StartSessionRequest;
import com.johndeere.tms.model.startsession.StartSessionResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public interface TmsController {

    @PostMapping(value = "/startSession")
    ResponseEntity<StartSessionResponse> startSession(
            @RequestBody() StartSessionRequest startSessionRequest
    );

    @PostMapping(value = "/addEvent")
    ResponseEntity<String> addEvent(
            @RequestBody() AddEventRequest addEventRequest
    );

    @PostMapping(value = "/endSession")
    ResponseEntity<String> endSession(
            @RequestBody() EndSessionRequest endSessionRequest
    );

    @GetMapping(value = "/getEvents")
    ResponseEntity<List<Events>> getEvents(
            @RequestParam() String sessionId
    );

}
