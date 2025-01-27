package com.blissom.adminservice.dto;

import java.time.LocalDateTime;

public class AdminActionLogRequest {
    private String adminId;
    private String action;
    private String details;
    private LocalDateTime timestamp;

    public AdminActionLogRequest() {}

    public AdminActionLogRequest(String adminId, String action, String details, LocalDateTime timestamp) {
        this.adminId = adminId;
        this.action = action;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

