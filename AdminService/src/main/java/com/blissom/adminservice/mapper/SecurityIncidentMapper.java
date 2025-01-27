package com.blissom.adminservice.mapper;

import com.blissom.adminservice.dto.SecurityIncidentRequest;
import com.blissom.adminservice.dto.SecurityIncidentResponse;
import com.blissom.adminservice.model.SecurityIncidentEntity;

public interface SecurityIncidentMapper {
    
    SecurityIncidentEntity toEntity(SecurityIncidentRequest request);
    
    SecurityIncidentResponse toResponse(SecurityIncidentEntity entity);
    
}


