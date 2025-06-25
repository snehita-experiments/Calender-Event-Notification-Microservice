package com.example.notification_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

// Use @Getter @Setter instead of @AllArgsConstructor when using @ConfigurationProperties.

@ConfigurationProperties(prefix = "twilio")
// @Getter
// @Setter
//@Configuration
public class TwilioConfig {
    // private String accountSid;
    // private String authToken;
    // private String phoneNumber;

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromNumber;

    public String getAccountSid() { return accountSid; }
    public String getAuthToken() { return authToken; }
    public String getFromNumber() { return fromNumber; }
}
