package com.example.notification_service.model;

import lombok.Data;

@Data
public class NotificationDTO {
    private String email;
    private String phone;
    private String message;
    private String type; // EMAIL, SMS

}
