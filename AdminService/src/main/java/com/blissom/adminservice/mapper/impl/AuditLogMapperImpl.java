package com.blissom.adminservice.mapper.impl;

import org.springframework.stereotype.Service;

import com.blissom.adminservice.dto.AdminActionLogRequest;
import com.blissom.adminservice.dto.AuditLogResponse;
import com.blissom.adminservice.mapper.AuditLogMapper;
import com.blissom.adminservice.model.AuditLogEntity;

@Service
public class AuditLogMapperImpl implements AuditLogMapper{

    public AuditLogEntity toEntity(AdminActionLogRequest request) {
        if (request == null) {
            return null;
        }
        AuditLogEntity entity = new AuditLogEntity();
        entity.setAdminId(request.getAdminId());
        entity.setAction(request.getAction());
        entity.setDetails(request.getDetails());
        entity.setTimestamp(request.getTimestamp());
        return entity;
    }

    public AuditLogResponse toResponse(AuditLogEntity entity) {
        if (entity == null) {
            return null;
        }
        AuditLogResponse response = new AuditLogResponse();
        response.setId(entity.getAuditLogId());
        response.setAdminId(entity.getAdminId());
        response.setAction(entity.getAction());
        response.setDetails(entity.getDetails());
        response.setTimestamp(entity.getTimestamp());
        return response;
    }
}

