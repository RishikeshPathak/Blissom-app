package com.blissom.adminservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SecurityIncidentEntity {

    @Id
    private String securityIncidentId;

    private String adminId;
    private String incidentType;
    private String description;
    private LocalDateTime timestamp;

	public String getSecurityIncidentId() {
		return securityIncidentId;
	}

	public void setSecurityIncidentId(String securityIncidentId) {
		this.securityIncidentId = securityIncidentId;
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

