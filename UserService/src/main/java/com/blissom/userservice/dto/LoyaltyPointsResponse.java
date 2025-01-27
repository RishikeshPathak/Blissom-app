package com.blissom.userservice.dto;

import java.time.LocalDateTime;

public class LoyaltyPointsResponse {
    private String userId;
    private int points;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public LoyaltyPointsResponse(String userId, int points, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = userId;
        this.points = points;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

