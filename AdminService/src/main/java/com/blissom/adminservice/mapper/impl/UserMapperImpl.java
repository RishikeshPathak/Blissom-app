package com.blissom.adminservice.mapper.impl;

import org.springframework.stereotype.Service;

import com.blissom.adminservice.dto.UserRequest;
import com.blissom.adminservice.dto.UserResponse;
import com.blissom.adminservice.mapper.UserMapper;
import com.blissom.adminservice.model.UserEntity;

@Service
public class UserMapperImpl implements UserMapper{

    public UserEntity toEntity(UserRequest request) {
        if (request == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        // Assuming setters are available in UserEntity
        entity.setUserName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setActive(request.isActive());
        // Add other fields as necessary
        return entity;
    }

    public UserResponse toResponse(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        UserResponse response = new UserResponse();
        // Assuming getters are available in UserEntity
        response.setId(userEntity.getUserId());
        response.setName(userEntity.getUserName());
        response.setEmail(userEntity.getEmail());
        response.setActive(userEntity.isActive());
        // Add other fields as necessary
        return response;
    }

    public void updateEntityFromRequest(UserRequest request, UserEntity userEntity) {
        if (request == null || userEntity == null) {
            return;
        }
        // Assuming setters are available in UserEntity
        if (request.getName() != null) {
            userEntity.setUserName(request.getName());
        }
        if (request.getEmail() != null) {
            userEntity.setEmail(request.getEmail());
        }
        if (request.isActive()) {
            userEntity.setActive(request.isActive());
        }
        // Add other fields as necessary
    }
}

