package com.blissom.catalogservice.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.blissom.catalogservice.dto.MediaRequest;
import com.blissom.catalogservice.dto.MediaResponse;
import com.blissom.catalogservice.model.MediaEntity;

@Mapper(componentModel = "spring")
public interface MediaMapper {

    @Mapping(target = "mediaId", ignore = true)
    MediaEntity toEntity(MediaRequest request);

    MediaResponse toResponse(MediaEntity entity);

    @Mapping(target = "mediaId", ignore = true)
    MediaEntity updateEntityFromRequest(MediaRequest request, @MappingTarget MediaEntity entity);

}

