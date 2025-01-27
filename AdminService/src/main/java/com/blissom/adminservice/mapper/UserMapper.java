package com.blissom.adminservice.mapper;

import com.blissom.adminservice.dto.UserRequest;
import com.blissom.adminservice.dto.UserResponse;
import com.blissom.adminservice.model.UserEntity;

public interface UserMapper {

    UserEntity toEntity(UserRequest request);

    UserResponse toResponse(UserEntity userEntity);

    void updateEntityFromRequest(UserRequest request, UserEntity userEntity);
}


