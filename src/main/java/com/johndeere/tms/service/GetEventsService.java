package com.johndeere.tms.service;

import com.johndeere.tms.exceptions.BadRequestException;
import com.johndeere.tms.model.addevent.Events;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface GetEventsService {

    ResponseEntity<List<Events>> getEvents(String sessionId) throws BadRequestException;

}
