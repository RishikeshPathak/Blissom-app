package com.blissom.userservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "activity_log")
public class ActivityLogEntity {
	
	@Id
    @Column(name = "log_id")
    private String logId;
	
    @Column(name = "user_id")
    private String userId;
    
    @Column(name = "activity")
    private String activity;
    
    @Column(name = "action")
    private String action;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
	
	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	private LocalDateTime timestamp;
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime now) {
		this.timestamp = now;
	}
	
}

