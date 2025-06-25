package com.example.notification_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notification_service.model.NotificationDTO;

@Service
public class NotificationService {

    private final TwilioSmsService twilioSmsService;

    @Autowired
    NotificationService(TwilioSmsService twilioSmsService) {
        this.twilioSmsService = twilioSmsService;
    }

    public void sendNotification(NotificationDTO notificationDTO) {
        System.out.println("Notification DTO Received: " + notificationDTO);
        System.out.println("Type: " + notificationDTO.getType());
        System.out.println("Phone: " + notificationDTO.getPhone());


        if ("phone".equalsIgnoreCase(notificationDTO.getType().trim()) && notificationDTO.getPhone() != null) {
            System.out.println("Sending SMS...");
            twilioSmsService.sendSms(notificationDTO.getPhone(), notificationDTO.getMessage());
        } else {
            System.out.println("The SMS is not sent. Either type is not 'phone' or phone is null.");
        }
    }

}
