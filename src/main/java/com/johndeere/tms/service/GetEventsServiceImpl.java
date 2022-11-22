package com.johndeere.tms.service;

import com.johndeere.tms.exceptions.BadRequestException;
import com.johndeere.tms.model.addevent.Events;
import com.johndeere.tms.model.database.EventsInfo;
import com.johndeere.tms.model.database.SessionInfo;
import com.johndeere.tms.repository.AddEventRepository;
import com.johndeere.tms.repository.SessionInfoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class GetEventsServiceImpl implements GetEventsService {

    @Autowired SessionInfoRepository sessionInfoRepository;

    @Override
    public ResponseEntity<List<Events>> getEvents(String sessionId) throws BadRequestException {

        List<EventsInfo> eventsInfos;

        Optional<SessionInfo> sessionInfoOptional = sessionInfoRepository.findById(UUID.fromString(sessionId));
        if (sessionInfoOptional.isPresent()){
            eventsInfos = sessionInfoOptional.get().getEventsInfos();
        } else {
            throw new BadRequestException(HttpStatus.BAD_GATEWAY,"Session Id not found in database");
        }

        List<Events> events = new ArrayList<>();
        for (EventsInfo eventsInfo: eventsInfos){
            events.add(new Events(eventsInfo.getEventAt().toString(), eventsInfo.getEventType(), eventsInfo.getPayload()));
        }

        HttpStatus status = eventsCheck(events);

        return new ResponseEntity<>(events, status);
    }

    private HttpStatus eventsCheck (List<Events> events){
        HttpStatus status;

        if(events.isEmpty()){
            status = HttpStatus.NO_CONTENT;
        } else{
            status = HttpStatus.OK;
        }
        return status;
    }

}
