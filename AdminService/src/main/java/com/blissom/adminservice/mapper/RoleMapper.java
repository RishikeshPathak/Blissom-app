package com.blissom.adminservice.mapper;

import com.blissom.adminservice.dto.AdminResponse;
import com.blissom.adminservice.dto.RoleRequest;
import com.blissom.adminservice.dto.RoleResponse;
import com.blissom.adminservice.dto.RoleUpdateRequest;
import com.blissom.adminservice.model.RoleEntity;

public interface RoleMapper {

    RoleEntity toEntity(RoleRequest request);

    RoleResponse toAdminEntityResponse(AdminResponse adminEntity);

    RoleResponse toResponse(RoleEntity roleEntity);

    void updateEntityFromRequest(RoleUpdateRequest request, RoleEntity roleEntity);

    AdminResponse toAdminEntityResponse(RoleEntity roleEntity);

}


