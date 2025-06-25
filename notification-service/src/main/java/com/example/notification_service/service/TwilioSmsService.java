package com.example.notification_service.service;

import org.springframework.stereotype.Service;

import com.example.notification_service.config.TwilioConfig;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioSmsService {

    private final TwilioConfig config;

    public TwilioSmsService(TwilioConfig config) {
        this.config = config;
    }

    public void sendSms(String to, String body) {

        // if (to == null || to.trim().isEmpty()) {
        //     throw new IllegalArgumentException("Recipient number is required.");
        // }

        // if (fromPhone.equals(to)) {
        //     System.out.println("Skipping SMS: Sender and recipient numbers are the same.");
        //     return;
        // }

        Twilio.init(config.getAccountSid(), config.getAuthToken());
        System.out.println("The phone number to be sent sms to");
        System.out.println(to);
        Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(config.getFromNumber()),
                body
        ).create();
    }
}
