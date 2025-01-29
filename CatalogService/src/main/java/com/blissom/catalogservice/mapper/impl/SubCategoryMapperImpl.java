package com.blissom.catalogservice.mapper.impl;

import org.springframework.stereotype.Component;

import com.blissom.catalogservice.dto.SubCategoryRequest;
import com.blissom.catalogservice.dto.SubCategoryResponse;
import com.blissom.catalogservice.mapper.SubCategoryMapper;
import com.blissom.catalogservice.model.SubCategoryEntity;

@Component
public class SubCategoryMapperImpl implements SubCategoryMapper {

    @Override
    public SubCategoryEntity toEntity(SubCategoryRequest request) {
        if (request == null) {
            return null;
        }

        SubCategoryEntity entity = new SubCategoryEntity();
        entity.setSubCategoryName(request.getName());
        // Assuming the category entity is set elsewhere
        return entity;
    }

    @Override
    public SubCategoryResponse toResponse(SubCategoryEntity subCategoryEntity) {
        if (subCategoryEntity == null) {
            return null;
        }

        SubCategoryResponse response = new SubCategoryResponse();
        response.setId(subCategoryEntity.getSubCategoryId());
        response.setName(subCategoryEntity.getSubCategoryName());
        response.setCategoryId(subCategoryEntity.getCategoryId());
        return response;
    }

    @Override
    public void updateEntityFromRequest(SubCategoryRequest request, SubCategoryEntity subCategoryEntity) {
        if (request == null || subCategoryEntity == null) {
            return;
        }

        subCategoryEntity.setSubCategoryName(request.getName());
        // Assuming the category entity is set elsewhere
    }
}


