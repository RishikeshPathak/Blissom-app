package com.blissom.userservice.mapper;

import com.blissom.userservice.dto.LoyaltyPointsResponse;
import com.blissom.userservice.model.LoyaltyPointsEntity;

public class LoyaltyPointsMapper {

    public static LoyaltyPointsResponse toLoyaltyPointsResponse(LoyaltyPointsEntity loyaltyPoints) {
        return new LoyaltyPointsResponse(
                loyaltyPoints.getUserId(),
                loyaltyPoints.getPoints(),
                loyaltyPoints.getCreatedAt(),
                loyaltyPoints.getUpdatedAt());
    }

}
