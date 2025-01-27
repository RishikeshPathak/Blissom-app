package com.blissom.adminservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blissom.adminservice.model.SecurityIncidentEntity;

public interface SecurityIncidentRepository extends JpaRepository<SecurityIncidentEntity, String> {

    @Query("SELECT s FROM SecurityIncidentEntity s WHERE s.timestamp BETWEEN :startDate AND :endDate")
    List<SecurityIncidentEntity> findByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);
}

