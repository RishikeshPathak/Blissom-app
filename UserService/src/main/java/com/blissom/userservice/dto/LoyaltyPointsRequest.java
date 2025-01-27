package com.blissom.userservice.dto;

public class LoyaltyPointsRequest {
    private String userId;
    private int points;

    public LoyaltyPointsRequest() {}

    public LoyaltyPointsRequest(String userId, int points) {
        this.userId = userId;
        this.points = points;
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
}

