package com.example.calender_service.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.calender_service.feign.CalenderInterface;
import com.example.calender_service.model.Event;
import com.example.calender_service.model.EventDTO;
import com.example.calender_service.model.NotificationDTO;
import com.example.calender_service.repository.CalenderRepository;

@Service
public class CalenderService {

    private CalenderRepository repository;
    private CalenderInterface notificationClient;

    @Autowired
    public CalenderService(CalenderRepository repository, CalenderInterface notificationClient) {
        this.repository = repository;
        this.notificationClient = notificationClient;
    }

    public Long save(EventDTO eventDTO) {
        Event event = new Event();

        event.setTitle(eventDTO.getTitle());
        event.setDescription(eventDTO.getDescription());
        event.setRecurrence(eventDTO.getRecurrence());
        event.setEmail(eventDTO.getEmail());
        event.setPhone(eventDTO.getPhone());
        event.setType(eventDTO.getType());

        // Convert LocalDateTime to ZonedDateTime (Asia/Kolkata)
        event.setStartTime(convertTimeStampToZonedDateTime(eventDTO.getStartTime()));
        Event savedEvent = repository.save(event);

        // Call notification service
        NotificationDTO dto = new NotificationDTO();
        dto.setMessage(event.getTitle()+"-"+event.getDescription());
        dto.setPhone(event.getPhone());
        dto.setEmail(event.getEmail());
        dto.setType("phone");

        System.out.println("Calling notification service"+ dto.toString());
        notificationClient.sendNotification(dto); // Feign call

        return savedEvent.getId();
    }

    private ZonedDateTime convertTimeStampToZonedDateTime(LocalDateTime startTime) {

        ZoneId indiaZone = ZoneId.of("Asia/Kolkata");
        ZonedDateTime zoneddatetime = startTime.atZone(indiaZone);
        return zoneddatetime;
    }

    public List<Event> findAll() {
        return repository.findAll();
    }

    public Event update(EventDTO eventDTO) {
        Event event = new Event();

        event.setTitle(eventDTO.getTitle());
        event.setDescription(eventDTO.getDescription());
        event.setRecurrence(eventDTO.getRecurrence());

        // Convert LocalDateTime to ZonedDateTime (Asia/Kolkata)
        event.setStartTime(convertTimeStampToZonedDateTime(eventDTO.getStartTime()));
        return repository.save(event);
    }

    public void delete(Long id) throws NoSuchElementFoundException {
        if (!repository.existsById(id))
            throw new NoSuchElementFoundException("Event with ID " + id + " not found");
        repository.deleteById(id);
    }

    public List<Event> search(String key) {
        List<Event> events = repository.findAllByKey(key);
        return events;
    }

}
