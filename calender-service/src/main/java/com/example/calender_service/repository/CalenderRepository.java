package com.example.calender_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.calender_service.model.Event;

@Repository
public interface CalenderRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE LOWER(e.title) LIKE LOWER(CONCAT('%', :key, '%')) or LOWER(e.description) LIKE LOWER(CONCAT('%', :key, '%'))")
    List<Event> findAllByKey(@Param("key") String key);

}
