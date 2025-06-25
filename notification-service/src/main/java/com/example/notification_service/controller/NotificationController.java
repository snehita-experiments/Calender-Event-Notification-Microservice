package com.example.notification_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notification_service.model.NotificationDTO;
import com.example.notification_service.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notifier")
    public String getNotificationString() {
        return "Hello";
    }

    // calender service notifies this service by posting a notification
    // {
    //     "email": "user@example.com",
    //     "phone": "944584395543",
    //     "message": "You have a new event tomorrow at 10 AM.",
    //     "type": "EMAIL"
    // }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationDTO notificationDTO) {
        System.out.println("The sendnotification method is called");
        notificationService.sendNotification(notificationDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Notification Sent Successfully");
    }

}
