package com.johndeere.tms.service;

import com.johndeere.tms.model.startsession.StartSessionRequest;
import com.johndeere.tms.model.startsession.StartSessionResponse;
import org.springframework.http.ResponseEntity;

public interface StartSessionService {

    ResponseEntity<StartSessionResponse> startSession(StartSessionRequest startSessionRequest);

}
