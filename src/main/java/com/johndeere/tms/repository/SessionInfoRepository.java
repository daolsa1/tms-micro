package com.johndeere.tms.repository;

import com.johndeere.tms.model.database.SessionInfo;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionInfoRepository extends CrudRepository<SessionInfo, UUID> {
}
