package com.johndeere.tms.model.database;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Id;

@Entity
@Data
public class SessionInfo{
    @Id
    @Column(length = 16)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID sessionId;
    private String userId;
    private String machineId;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private Integer orgId;
    private Boolean active;

    @OneToMany(mappedBy = "sessionInfo")
    private List<EventsInfo> eventsInfos = new ArrayList<>();

    public SessionInfo(String userId, String machineId, LocalDateTime startAt, Integer orgId, Boolean active){
        this.userId = userId;
        this.machineId = machineId;
        this.startAt = startAt;
        this.orgId = orgId;
        this.active = active;
    }

    public SessionInfo(){}
}