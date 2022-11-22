package com.johndeere.tms.service;

import com.johndeere.tms.exceptions.BadRequestException;
import com.johndeere.tms.exceptions.InvalidSessionException;
import com.johndeere.tms.model.addevent.AddEventRequest;
import org.springframework.http.ResponseEntity;

public interface AddEventService {

    ResponseEntity<String> addEvent(AddEventRequest addEventRequest)
            throws InvalidSessionException, BadRequestException;

}
