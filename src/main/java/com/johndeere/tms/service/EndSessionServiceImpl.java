package com.johndeere.tms.service;

import com.johndeere.tms.exceptions.BadRequestException;
import com.johndeere.tms.model.database.SessionInfo;
import com.johndeere.tms.model.endsession.EndSessionRequest;
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
public class EndSessionServiceImpl implements EndSessionService {

    @Autowired SessionInfoRepository sessionInfoRepository;

    @Override
    public ResponseEntity<String> endSession(EndSessionRequest endSessionRequest)
            throws BadRequestException {
        return updateSessionInfo(endSessionRequest);
    }

    private ResponseEntity<String> updateSessionInfo(EndSessionRequest endSessionRequest)
            throws BadRequestException {
        SessionInfo sessionInfo;

        Optional<SessionInfo> sessionInfoOptional = sessionInfoRepository.findById(UUID.fromString(endSessionRequest.getSessionId()));
        if(sessionInfoOptional.isPresent()){
            sessionInfo = sessionInfoOptional.get();
            sessionInfo.setEndAt(LocalDateTime.parse(endSessionRequest.getEndAt(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            sessionInfo.setActive(false);
            sessionInfoRepository.save(sessionInfo);
        } else{
            throw new BadRequestException(HttpStatus.BAD_GATEWAY,"Session Id not found in database");
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

