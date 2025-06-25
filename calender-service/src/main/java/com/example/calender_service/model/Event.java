package com.example.calender_service.model;

import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private ZonedDateTime startTime; // this includes date + time + zone
    //private RecurrenceType recurrence;
    //private CommunicationMode prefrCommunicationMode;
    private String recurrence;
    private String type;
    private String email;
    private String phone;

}
