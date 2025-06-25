package com.example.calender_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calender_service.model.Event;
import com.example.calender_service.model.EventDTO;
import com.example.calender_service.service.CalenderService;


@RestController
@RequestMapping("/calender")
public class CalenderController {

    private final CalenderService calenderService;

    @Autowired
    public CalenderController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }

    // Sample endpoint: GET http://localhost:8080/calender/sneha
    @GetMapping("/{name}")
    public String getStarted(@PathVariable String name) {
        return "Hello "+name;
    }

    // Create event: POST http://localhost:8080/calender/create
    @PostMapping("/create")
    public ResponseEntity<Long> createEvent(@Validated @RequestBody EventDTO event) {
        // Save logic should return confirmation or event ID
        return new ResponseEntity<>(calenderService.save(event), HttpStatus.OK);
    }

    // Get events: Get http://localhost:8080/calender/allEvents
    @GetMapping("/allEvents")
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(calenderService.findAll(), HttpStatus.OK);
    }

    // Put events: Put http://localhost:8080/calender/update
    @PutMapping("/update")
    public ResponseEntity<Event> updateEvent(@RequestBody EventDTO eventDTO) {
        return new ResponseEntity<>(calenderService.update(eventDTO), HttpStatus.OK);
    }
    
    // Delete events: Delete http://localhost:8080/calender/delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        try {
            calenderService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }        
    }

    // Search events: Get http://localhost:8080/calender/search
    @GetMapping("/search")
    public ResponseEntity<List<Event>> searchEvents(@RequestParam String key) {
        return new ResponseEntity<>(calenderService.search(key), HttpStatus.OK);
    }

}
