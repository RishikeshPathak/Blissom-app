package com.blissom.adminservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AuditLogEntity {

    @Id
    private String auditLogId;

    private String adminId;
    private String action;
    private String details;
    private LocalDateTime timestamp;



    public String getAuditLogId() {
		return auditLogId;
	}

	public void setAuditLogId(String auditLogId) {
		this.auditLogId = auditLogId;
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


