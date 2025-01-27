package com.blissom.userservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loyalty_points")
public class LoyaltyPointsEntity {
    @Id
    private String loyaltyPointsId;

    private String userId;

    private int points;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    public LoyaltyPointsEntity() {
    }

    public LoyaltyPointsEntity(String userId, int points) {
        this.userId = userId;
        this.points = points;
    }

    public String getLoyaltyPointsId() {
        return loyaltyPointsId;
    }
    public void setLoyaltyPointsId(String loyaltyPointsId) {
        this.loyaltyPointsId = loyaltyPointsId;     
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

	public void addPoints(int points) {
        this.points += points;
        this.updatedAt = LocalDateTime.now();
    }

    public void deductPoints(int points) {
        if (this.points < points) {
            throw new IllegalArgumentException("Not enough points to deduct");
        }
        this.points -= points;
        this.updatedAt = LocalDateTime.now();
    }
}


