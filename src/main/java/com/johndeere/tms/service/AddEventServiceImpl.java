package com.johndeere.tms.service;

import com.johndeere.tms.exceptions.BadRequestException;
import com.johndeere.tms.exceptions.InvalidSessionException;
import com.johndeere.tms.model.addevent.AddEventRequest;
import com.johndeere.tms.model.addevent.Events;
import com.johndeere.tms.model.database.EventsInfo;
import com.johndeere.tms.model.database.SessionInfo;
import com.johndeere.tms.repository.AddEventRepository;
import com.johndeere.tms.repository.SessionInfoRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class AddEventServiceImpl implements AddEventService {

    @Autowired SessionInfoRepository sessionInfoRepository;
    @Autowired AddEventRepository addEventRepository;

    @Override
    public ResponseEntity<String> addEvent(AddEventRequest addEventRequest)
            throws InvalidSessionException, BadRequestException {

        SessionInfo sessionInfo;

        Optional<SessionInfo> sessionInfoOptional = sessionInfoRepository.findById(UUID.fromString(addEventRequest.getSessionId()));
        if(sessionInfoOptional.isPresent()){
            sessionInfo = sessionInfoOptional.get();
        } else{
            throw new BadRequestException(HttpStatus.BAD_GATEWAY,"Session Id not found in database");
        }

        if(sessionInfo.getActive()){
            EventsInfo eventsInfo;
            for (Events s : addEventRequest.getEvents()) {
                eventsInfo = new EventsInfo(sessionInfo, s.getEventType(),
                        LocalDateTime.parse(s.getEventAt(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                        s.getPayload());
                addEventRepository.save(eventsInfo);
            }
        } else{
            throw new InvalidSessionException(HttpStatus.BAD_GATEWAY,"Session expired");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
