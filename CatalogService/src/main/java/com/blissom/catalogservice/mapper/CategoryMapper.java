package com.blissom.catalogservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.blissom.catalogservice.dto.CategoryRequest;
import com.blissom.catalogservice.dto.CategoryResponse;
import com.blissom.catalogservice.model.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryEntity toEntity(CategoryRequest categoryRequest);

    CategoryResponse toResponse(CategoryEntity categoryEntity);

    void updateEntityFromRequest(CategoryRequest categoryRequest, @MappingTarget CategoryEntity categoryEntity);
}



