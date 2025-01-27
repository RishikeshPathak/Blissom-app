package com.blissom.adminservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blissom.adminservice.model.AuditLogEntity;

public interface AuditLogRepository extends JpaRepository<AuditLogEntity, String> {

    List<AuditLogEntity> findByAdminId(String adminId);

    List<AuditLogEntity> findByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT a FROM AuditLogEntity a WHERE a.timestamp BETWEEN :startDate AND :endDate")
    List<AuditLogEntity> findByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);

}

