package com.johndeere.tms.service;

import com.johndeere.tms.exceptions.BadRequestException;
import com.johndeere.tms.model.endsession.EndSessionRequest;
import org.springframework.http.ResponseEntity;

public interface EndSessionService {

    ResponseEntity<String> endSession(EndSessionRequest endSessionRequest) throws BadRequestException;
}
