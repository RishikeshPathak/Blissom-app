package com.blissom.userservice.mapper;

import com.blissom.userservice.dto.ActivityLogResponse;
import com.blissom.userservice.model.ActivityLogEntity;

public class ActivityLogMapper {
    // existing code...
    
    public static ActivityLogResponse toActivityLogResponse(ActivityLogEntity entity) {
        ActivityLogResponse response = new ActivityLogResponse();
        response.setUserId(entity.getUserId());
        response.setActivity(entity.getActivity());
        response.setCreatedAt(entity.getCreatedAt());
        return response;
    }
}
