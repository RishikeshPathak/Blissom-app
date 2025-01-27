package com.blissom.adminservice.mapper;

import com.blissom.adminservice.dto.AdminActionLogRequest;
import com.blissom.adminservice.dto.AuditLogResponse;
import com.blissom.adminservice.model.AuditLogEntity;

public interface AuditLogMapper {

    AuditLogEntity toEntity(AdminActionLogRequest request);

    AuditLogResponse toResponse(AuditLogEntity entity);
}


