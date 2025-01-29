package com.blissom.catalogservice.mapper.impl;


import org.springframework.stereotype.Component;

import com.blissom.catalogservice.dto.CategoryRequest;
import com.blissom.catalogservice.dto.CategoryResponse;
import com.blissom.catalogservice.mapper.CategoryMapper;
import com.blissom.catalogservice.model.CategoryEntity;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryEntity toEntity(CategoryRequest categoryRequest) {
        if (categoryRequest == null) {
            return null;
        }
        CategoryEntity entity = new CategoryEntity();
        entity.setCategoryName(categoryRequest.getName());
        entity.setCategoryActive(categoryRequest.isActive());
        return entity;
    }

    @Override
    public CategoryResponse toResponse(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            return null;
        }
        CategoryResponse response = new CategoryResponse();
        response.setName(categoryEntity.getCategoryName());
        response.setActive(categoryEntity.isCategoryActive());
        return response;
    }

    @Override
    public void updateEntityFromRequest(CategoryRequest categoryRequest, CategoryEntity categoryEntity) {
        if (categoryRequest == null || categoryEntity == null) {
            return;
        }
        categoryEntity.setCategoryName(categoryRequest.getName());
        categoryEntity.setCategoryActive(categoryRequest.isActive());
    }

}
