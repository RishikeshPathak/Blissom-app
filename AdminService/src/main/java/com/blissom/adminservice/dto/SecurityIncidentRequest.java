package com.blissom.adminservice.dto;

import java.time.LocalDateTime;

public class SecurityIncidentRequest {

    private String adminId;
    private String incidentType;
    private String description;
    private LocalDateTime timestamp;

    public SecurityIncidentRequest() {
    }

    public SecurityIncidentRequest(String adminId, String incidentType, String description, LocalDateTime timestamp) {
        this.adminId = adminId;
        this.incidentType = incidentType;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

