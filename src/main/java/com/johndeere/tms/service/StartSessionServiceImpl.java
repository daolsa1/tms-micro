package com.johndeere.tms.service;

import com.johndeere.tms.model.database.SessionInfo;
import com.johndeere.tms.model.startsession.StartSessionRequest;
import com.johndeere.tms.model.startsession.StartSessionResponse;
import com.johndeere.tms.repository.SessionInfoRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StartSessionServiceImpl implements StartSessionService {

    @Autowired SessionInfoRepository sessionInfoRepository;

    @Override
    public ResponseEntity<StartSessionResponse> startSession(
            StartSessionRequest startSessionRequest) {
        return createSessionInfo(startSessionRequest);
    }

    public ResponseEntity<StartSessionResponse> createSessionInfo(StartSessionRequest startSessionRequest){
        SessionInfo sessionInfo = new SessionInfo(startSessionRequest.getUserId(), startSessionRequest.getMachineId(), LocalDateTime.parse(startSessionRequest.getStartAt(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), startSessionRequest.getOrgId(), true);
        sessionInfo = sessionInfoRepository.save(sessionInfo);
        StartSessionResponse response = new StartSessionResponse(sessionInfo.getSessionId().toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}