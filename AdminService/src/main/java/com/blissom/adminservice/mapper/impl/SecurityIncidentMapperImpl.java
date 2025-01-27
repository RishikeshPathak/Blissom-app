package com.blissom.adminservice.mapper.impl;

import org.springframework.stereotype.Service;

import com.blissom.adminservice.dto.SecurityIncidentRequest;
import com.blissom.adminservice.dto.SecurityIncidentResponse;
import com.blissom.adminservice.mapper.SecurityIncidentMapper;
import com.blissom.adminservice.model.SecurityIncidentEntity;

@Service
public class SecurityIncidentMapperImpl implements SecurityIncidentMapper{
    
    public  SecurityIncidentEntity toEntity(SecurityIncidentRequest request) {
        SecurityIncidentEntity entity = new SecurityIncidentEntity();
        entity.setAdminId(request.getAdminId());
        entity.setIncidentType(request.getIncidentType());
        entity.setDescription(request.getDescription());
        entity.setTimestamp(request.getTimestamp());
        return entity;
    }
    
    public  SecurityIncidentResponse toResponse(SecurityIncidentEntity entity) {
        SecurityIncidentResponse response = new SecurityIncidentResponse();
        response.setId(entity.getSecurityIncidentId());
        response.setAdminId(entity.getAdminId());
        response.setIncidentType(entity.getIncidentType());
        response.setDescription(entity.getDescription());
        response.setTimestamp(entity.getTimestamp());
        return response;
    }
    
}

