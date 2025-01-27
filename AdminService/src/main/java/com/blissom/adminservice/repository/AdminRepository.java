package com.blissom.adminservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blissom.adminservice.model.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, String> {

    @Query("SELECT a FROM AdminEntity a WHERE a.lastLogin BETWEEN :startDate AND :endDate")
    List<AdminEntity> findActivityAnalytics(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query("SELECT COUNT(a) FROM AdminEntity a WHERE a.active = :active")
    int countByActive(@Param("active") boolean active);

    @Modifying
    @Query("UPDATE AdminEntity a SET a.active = :active WHERE a.id IN (:adminIds)")
    boolean bulkUpdateActiveStatus(@Param("adminIds") List<String> adminIds, @Param("active") boolean active);

}

