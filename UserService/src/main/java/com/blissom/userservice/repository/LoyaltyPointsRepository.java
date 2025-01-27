package com.blissom.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blissom.userservice.model.LoyaltyPointsEntity;


public interface LoyaltyPointsRepository extends JpaRepository<LoyaltyPointsEntity, String> {

    @Query("SELECT l FROM LoyaltyPointsEntity l WHERE l.userId = :userId")
    Optional<LoyaltyPointsEntity> findByUserId(@Param("userId") String userId);
}