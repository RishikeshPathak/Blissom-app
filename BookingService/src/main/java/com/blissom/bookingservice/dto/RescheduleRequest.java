package com.blissom.bookingservice.dto;

import java.time.LocalDateTime;

public class RescheduleRequest {
    private String bookingId;
    private LocalDateTime newScheduledTime;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getNewScheduledTime() {
        return newScheduledTime;
    }

    public void setNewScheduledTime(LocalDateTime newScheduledTime) {
        this.newScheduledTime = newScheduledTime;
    }
}

