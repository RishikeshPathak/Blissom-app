package com.blissom.catalogservice.mapper;

import com.blissom.catalogservice.dto.SubCategoryRequest;
import com.blissom.catalogservice.dto.SubCategoryResponse;
import com.blissom.catalogservice.model.SubCategoryEntity;

public interface SubCategoryMapper {

    SubCategoryEntity toEntity(SubCategoryRequest request);

    SubCategoryResponse toResponse(SubCategoryEntity subCategoryEntity);

    void updateEntityFromRequest(SubCategoryRequest request, SubCategoryEntity subCategoryEntity);

}
