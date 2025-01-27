package com.blissom.adminservice.mapper;

import com.blissom.adminservice.dto.AdminAnalyticsResponse;
import com.blissom.adminservice.dto.AdminRequest;
import com.blissom.adminservice.dto.AdminResponse;
import com.blissom.adminservice.dto.AdminUpdateRequest;
import com.blissom.adminservice.model.AdminEntity;

public interface AdminMapper {

    AdminEntity toEntity(AdminRequest request);

    AdminResponse toResponse(AdminEntity adminEntity);

    void updateEntityFromRequest(AdminUpdateRequest request, AdminEntity adminEntity);
    
    AdminAnalyticsResponse toAnalyticsResponse(AdminEntity adminEntity);


}

