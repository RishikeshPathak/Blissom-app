package com.blissom.adminservice.dto;

import java.time.LocalDateTime;

public class AuditLogResponse {

    private String id;
    private String adminId;
    private String action;
    private String details;
    private LocalDateTime timestamp;

    public AuditLogResponse() {}

    public AuditLogResponse(String id, String adminId, String action, String details, LocalDateTime timestamp) {
        this.id = id;
        this.adminId = adminId;
        this.action = action;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

