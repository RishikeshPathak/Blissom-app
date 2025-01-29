package com.blissom.catalogservice.mapper;

import com.blissom.catalogservice.dto.ServiceRequest;
import com.blissom.catalogservice.dto.ServiceResponse;
import com.blissom.catalogservice.model.ServiceEntity;

public interface ServiceMapper {

    ServiceEntity toEntity(ServiceRequest request);

    ServiceResponse toResponse(ServiceEntity serviceEntity);

    void updateEntityFromRequest(ServiceRequest request, ServiceEntity serviceEntity);

}
