package com.blissom.adminservice.mapper.impl;

import org.springframework.stereotype.Service;

import com.blissom.adminservice.dto.AdminResponse;
import com.blissom.adminservice.dto.RoleRequest;
import com.blissom.adminservice.dto.RoleResponse;
import com.blissom.adminservice.dto.RoleUpdateRequest;
import com.blissom.adminservice.mapper.RoleMapper;
import com.blissom.adminservice.model.RoleEntity;

@Service
public class RoleMapperImpl implements RoleMapper{

    public RoleEntity toEntity(RoleRequest request) {
        RoleEntity entity = new RoleEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }

    public RoleResponse toAdminEntityResponse(AdminResponse adminEntity) {
        RoleResponse response = new RoleResponse();
        response.setId(adminEntity.getId());
        response.setName(adminEntity.getName());
        response.setDescription(adminEntity.getDescription());
        return response;
    }

    public RoleResponse toResponse(RoleEntity roleEntity) {
        RoleResponse response = new RoleResponse();
        response.setId(roleEntity.getRoleId());
        response.setName(roleEntity.getName());
        response.setDescription(roleEntity.getDescription());
        return response;
    }

    public void updateEntityFromRequest(RoleUpdateRequest request, RoleEntity roleEntity) {
        if (request.getName() != null) {
            roleEntity.setName(request.getName());
        }
        if (request.getDescription() != null) {
            roleEntity.setDescription(request.getDescription());
        }
    }

    public AdminResponse toAdminEntityResponse(RoleEntity roleEntity) {
        AdminResponse response = new AdminResponse();
        response.setId(roleEntity.getRoleId());
        response.setName(roleEntity.getName());
        response.setDescription(roleEntity.getDescription());
        return response;
    }

}

