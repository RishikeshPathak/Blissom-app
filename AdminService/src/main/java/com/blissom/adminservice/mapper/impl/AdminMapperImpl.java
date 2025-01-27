package com.blissom.adminservice.mapper.impl;

import org.springframework.stereotype.Service;

import com.blissom.adminservice.dto.AdminAnalyticsResponse;
import com.blissom.adminservice.dto.AdminRequest;
import com.blissom.adminservice.dto.AdminResponse;
import com.blissom.adminservice.dto.AdminUpdateRequest;
import com.blissom.adminservice.mapper.AdminMapper;
import com.blissom.adminservice.model.AdminEntity;

@Service
public class AdminMapperImpl implements AdminMapper{

    public AdminEntity toEntity(AdminRequest request) {
        if (request == null) {
            return null;
        }
        AdminEntity entity = new AdminEntity();
        // Assuming setters are available in AdminEntity
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setEmail(request.getEmail());
        entity.setActive(request.isActive());
        entity.setCreatedAt(request.getCreatedAt());
        return entity;
    }

    public AdminResponse toResponse(AdminEntity adminEntity) {
        if (adminEntity == null) {
            return null;
        }
        AdminResponse response = new AdminResponse();
        // Assuming getters are available in AdminEntity
        response.setId(adminEntity.getAdminId());
        response.setFirstName(adminEntity.getFirstName());
        response.setLastName(adminEntity.getLastName());
        response.setEmail(adminEntity.getEmail());
        response.setActive(adminEntity.isActive());
        response.setCreatedAt(adminEntity.getCreatedAt());
        return response;
    }

    public void updateEntityFromRequest(AdminUpdateRequest request, AdminEntity adminEntity) {
        if (request == null || adminEntity == null) {
            return;
        }
        // Assuming setters are available in AdminEntity
        if (request.getName() != null) {
            adminEntity.setFirstName(request.getFirstName());
            adminEntity.setLastName(request.getLastName());
        }
        if (request.getEmail() != null) {
            adminEntity.setEmail(request.getEmail());
        }
        if (request.getActive()) {
            adminEntity.setActive(request.getActive());
        }
    }

    public AdminAnalyticsResponse toAnalyticsResponse(AdminEntity adminEntity) {
        if (adminEntity == null) {
            return null;
        }
        AdminAnalyticsResponse response = new AdminAnalyticsResponse();
        response.setAdminId(adminEntity.getAdminId());
        response.setFirstName(adminEntity.getFirstName());
        response.setLastName(adminEntity.getLastName());
        response.setEmail(adminEntity.getEmail());
        // Assuming the following methods are implemented to fetch the relevant data
        response.setLastLogin(adminEntity.getLastLogin());
        response.setTotalActions(adminEntity.getTotalActions());
        response.setTotalLogs(adminEntity.getTotalActions());
        return response;
    }


}

