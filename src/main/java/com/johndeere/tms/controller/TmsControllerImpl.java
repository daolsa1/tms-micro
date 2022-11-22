package com.johndeere.tms.controller;

import com.johndeere.tms.exceptions.BadRequestException;
import com.johndeere.tms.exceptions.InvalidSessionException;
import com.johndeere.tms.model.addevent.AddEventRequest;
import com.johndeere.tms.model.startsession.StartSessionRequest;
import com.johndeere.tms.model.startsession.StartSessionResponse;
import com.johndeere.tms.service.AddEventService;
import com.johndeere.tms.service.StartSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequiredArgsConstructor
public class TmsControllerImpl implements TmsController {

    private final StartSessionService startSessionService;

    private final AddEventService addEventService;

    @Override
    public ResponseEntity<StartSessionResponse> startSession(
            StartSessionRequest startSessionRequest) {
        try {
            return this.startSessionService.startSession(startSessionRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public ResponseEntity<String> addEvent(AddEventRequest addEventRequest) {
        try {
            return this.addEventService.addEvent(addEventRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(InvalidSessionException.class)
    public Map<String, String> handleInvalidSessionExceptions(InvalidSessionException ex) {
        Map<String, String> errors = new TreeMap<>();
        errors.put("description", ex.getErrorString());
        errors.put("statusCode", ex.getHttpStatus().toString());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(BadRequestException.class)
    public Map<String, String> handleBadRequestExceptions(BadRequestException ex) {
        Map<String, String> errors = new TreeMap<>();
        errors.put("description", ex.getErrorString());
        errors.put("statusCode", ex.getHttpStatus().toString());
        return errors;
    }
}