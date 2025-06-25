package com.example.calender_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.calender_service.model.NotificationDTO;


@FeignClient(name="notification-service")
public interface CalenderInterface {
    @PostMapping("/notification/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationDTO notificationDTO);

}
