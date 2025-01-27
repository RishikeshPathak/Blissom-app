package com.blissom.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blissom.userservice.model.PreferencesEntity;

@Repository
public interface PreferencesRepository extends JpaRepository<PreferencesEntity, String> {
    @Query("SELECT p FROM PreferencesEntity p WHERE p.userId = :userId")
    Optional<PreferencesEntity> findByUserIdQuery(@Param("userId") String userId);
}


