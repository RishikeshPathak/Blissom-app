package com.blissom.adminservice.dto;

import java.time.LocalDateTime;

public class SecurityIncidentResponse {
    private String id;
    private String adminId;
    private String incidentType;
    private String description;
    private LocalDateTime timestamp;

    public SecurityIncidentResponse() {}

    public SecurityIncidentResponse(String id, String adminId, String incidentType, String description, LocalDateTime timestamp) {
        this.id = id;
        this.adminId = adminId;
        this.incidentType = incidentType;
        this.description = description;
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

