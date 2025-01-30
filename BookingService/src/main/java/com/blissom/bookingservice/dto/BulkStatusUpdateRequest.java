package com.blissom.bookingservice.dto;

import java.util.List;

public class BulkStatusUpdateRequest {
    private List<String> bookingIds;
    private String newStatus;

    public List<String> getBookingIds() {
        return bookingIds;
    }

    public void setBookingIds(List<String> bookingIds) {
        this.bookingIds = bookingIds;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }
}

