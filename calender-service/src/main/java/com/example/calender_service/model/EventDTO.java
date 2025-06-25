package com.example.calender_service.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

    private String title;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    @Future(message = "Event start time must be in the future")
    private LocalDateTime startTime;

    // @NotBlank(message = "Time zone is required")
    // private String timeZone;

    // @Enumerated(EnumType.STRING)
    // @NotNull(message = "Recurrence is required")
    // private RecurrenceType recurrence;
    private String recurrence;


    // private CommunicationMode modeOfCommunication;
    private String type;

    // @Schema(description = "Email address to send the notification to")
    // @Email(message = "Invalid email format")
    private String email;

    // @Schema(description = "10-digit Indian phone number to send SMS")
    // @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid Indian phone number")
    private String phone;

}