package com.blissom.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blissom.userservice.model.SecurityQuestionEntity;

public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestionEntity, String> {

    @Query("SELECT s FROM SecurityQuestionEntity s WHERE s.userId = :userId")
    Optional<SecurityQuestionEntity> findByUserId(@Param("userId") String userId);

}

