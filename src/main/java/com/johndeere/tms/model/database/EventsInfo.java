package com.johndeere.tms.model.database;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class EventsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int internalId;
    @ManyToOne
    @JoinColumn(name = "fkSessionInfo")
    private SessionInfo sessionInfo;
    private String eventType;
    private LocalDateTime eventAt;
    private String payload;

    public EventsInfo(SessionInfo sessionInfo, String eventType, LocalDateTime eventAt, String payload){
        this.sessionInfo = sessionInfo;
        this.eventType = eventType;
        this.eventAt = eventAt;
        this.payload = payload;
    }

    public EventsInfo(){}
}