package com.blissom.bookingservice.dto;

import java.time.LocalDateTime;

public class BookingStatusResponse {
    private String bookingId;
    private LocalDateTime scheduledTime;
    private String status;

    public BookingStatusResponse() {}

    public BookingStatusResponse(String bookingId, LocalDateTime scheduledTime, String status) {
        this.bookingId = bookingId;
        this.scheduledTime = scheduledTime;
        this.status = status;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

