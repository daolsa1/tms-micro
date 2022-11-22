package com.johndeere.tms.controller;

import com.johndeere.tms.model.startsession.StartSessionRequest;
import com.johndeere.tms.model.startsession.StartSessionResponse;
import com.johndeere.tms.service.StartSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TmsControllerImpl implements TmsController {

    private final StartSessionService startSessionService;

    @Override
    public ResponseEntity<StartSessionResponse> startSession(
            StartSessionRequest startSessionRequest) {
        try {
            return this.startSessionService.startSession(startSessionRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}