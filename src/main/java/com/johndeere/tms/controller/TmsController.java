package com.johndeere.tms.controller;

import com.johndeere.tms.model.startsession.StartSessionRequest;
import com.johndeere.tms.model.startsession.StartSessionResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public interface TmsController {

    @PostMapping(value = "/startSession")
    ResponseEntity<StartSessionResponse> startSession(
            @RequestBody() StartSessionRequest startSessionRequest
    );

}
