package com.blissom.catalogservice.mapper.impl;


import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.blissom.catalogservice.dto.MediaRequest;
import com.blissom.catalogservice.dto.MediaResponse;
import com.blissom.catalogservice.mapper.MediaMapper;
import com.blissom.catalogservice.model.MediaEntity;

@Component
public class MediaMapperImpl implements MediaMapper {

    @Override
    public MediaEntity toEntity(MediaRequest request) {
        MediaEntity entity = new MediaEntity();
        entity.setMediaId(request.getMediaId());
        entity.setMediaURL(request.getMediaURL());
        entity.setMediaType(request.getMediaType());
        entity.setMediaName(request.getMediaName());
        entity.setMediaDescription(request.getMediaDescription());
        entity.setMediaSize(request.getMediaSize());
        entity.setMediaWidth(request.getMediaWidth());
        entity.setMediaHeight(request.getMediaHeight());
        entity.setMediaDuration(request.getMediaDuration());
        entity.setMediaFormat(request.getMediaFormat());
        entity.setMediaThumbnail(request.getMediaThumbnail());
        entity.setMediaStatus(request.getMediaStatus());
        entity.setMediaVisibility(request.getMediaVisibility());
        entity.setMediaLocation(request.getMediaLocation());
        entity.setMediaCategory(request.getMediaCategory());
        entity.setMediaSubCategory(request.getMediaSubCategory());
        entity.setMediaTags(request.getMediaTags());
        return entity;
    }

    @Override
    public MediaResponse toResponse(MediaEntity entity) {
        MediaResponse response = new MediaResponse();
        response.setMediaId(entity.getMediaId());
        response.setMediaURL(entity.getMediaURL());
        response.setMediaType(entity.getMediaType());
        response.setMediaName(entity.getMediaName());
        response.setMediaDescription(entity.getMediaDescription());
        response.setMediaSize(entity.getMediaSize());
        response.setMediaWidth(entity.getMediaWidth());
        response.setMediaHeight(entity.getMediaHeight());
        response.setMediaDuration(entity.getMediaDuration());
        response.setMediaFormat(entity.getMediaFormat());
        response.setMediaThumbnail(entity.getMediaThumbnail());
        response.setMediaStatus(entity.getMediaStatus());
        response.setMediaVisibility(entity.getMediaVisibility());
        response.setMediaLocation(entity.getMediaLocation());
        response.setMediaCategory(entity.getMediaCategory());
        response.setMediaSubCategory(entity.getMediaSubCategory());
        response.setMediaTags(entity.getMediaTags());
        return response;
    }

    @Override
    public MediaEntity updateEntityFromRequest(MediaRequest request, @MappingTarget MediaEntity entity) {
        
        entity.setMediaId(request.getMediaId());
        entity.setMediaURL(request.getMediaURL());
        entity.setMediaType(request.getMediaType());
        entity.setMediaName(request.getMediaName());
        entity.setMediaDescription(request.getMediaDescription());
        entity.setMediaSize(request.getMediaSize());
        entity.setMediaWidth(request.getMediaWidth());
        entity.setMediaHeight(request.getMediaHeight());
        entity.setMediaDuration(request.getMediaDuration());
        entity.setMediaFormat(request.getMediaFormat());
        entity.setMediaThumbnail(request.getMediaThumbnail());
        entity.setMediaStatus(request.getMediaStatus());
        entity.setMediaVisibility(request.getMediaVisibility());
        entity.setMediaLocation(request.getMediaLocation());
        entity.setMediaCategory(request.getMediaCategory());
        entity.setMediaSubCategory(request.getMediaSubCategory());
        entity.setMediaTags(request.getMediaTags());
        return entity;
    }
}
