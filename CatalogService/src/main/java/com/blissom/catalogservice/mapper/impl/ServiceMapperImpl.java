package com.blissom.catalogservice.mapper.impl;




import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.blissom.catalogservice.dto.ServiceRequest;
import com.blissom.catalogservice.dto.ServiceResponse;
import com.blissom.catalogservice.mapper.ServiceMapper;
import com.blissom.catalogservice.model.ServiceEntity;

@Mapper(componentModel = "spring")
@Component
public class ServiceMapperImpl implements ServiceMapper {


    @Override
    public ServiceEntity toEntity(ServiceRequest request) {
        ServiceEntity entity = new ServiceEntity();
        entity.setServiceName(request.getServiceName());
        entity.setServiceDescription(request.getServiceDescription());
        entity.setPrice(request.getPrice());
        entity.setActive(request.isActive());
        return entity;
    }

    @Override
    public ServiceResponse toResponse(ServiceEntity entity) {
        ServiceResponse response = new ServiceResponse();
        response.setServiceId(entity.getServiceId());
        response.setServiceName(entity.getServiceName());
        response.setServiceDescription(entity.getServiceDescription());
        response.setPrice(entity.getPrice());
        response.setActive(entity.isActive());
        return response;
    }

    @Override
    public void updateEntityFromRequest(ServiceRequest request, @MappingTarget ServiceEntity entity) {
        entity.setServiceName(request.getServiceName());
        entity.setServiceDescription(request.getServiceDescription());
        entity.setPrice(request.getPrice());
        entity.setActive(request.isActive());
    }
}

