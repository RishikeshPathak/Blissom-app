package com.blissom.catalogservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blissom.catalogservice.model.MediaEntity;

public interface MediaRepository extends JpaRepository<MediaEntity, String> {

    MediaEntity save(MediaEntity media);

    Optional<MediaEntity> findById(String mediaId);

    void delete(MediaEntity media);

    @Query("SELECT m FROM MediaEntity m WHERE m.mediaCategory = ?1 AND m.mediaStatus = ?2")
    List<MediaEntity> findByMediaCategoryAndMediaStatus(String mediaCategory, String mediaStatus);



}
