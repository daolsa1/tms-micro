package com.johndeere.tms.repository;

import com.johndeere.tms.model.database.EventsInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddEventRepository extends CrudRepository<EventsInfo,Integer> {
}
