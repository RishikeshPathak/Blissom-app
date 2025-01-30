package com.blissom.bookingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blissom.bookingservice.model.AvailabilityEntity;

public interface ProfessionalAvailabilityRepository extends JpaRepository<AvailabilityEntity, String> {

    @Query("SELECT a FROM AvailabilityEntity a WHERE a.professionalId = ?1 AND a.date = ?2 AND a.timeSlots IS NOT EMPTY")
    List<AvailabilityEntity> findAvailableSlots(String professionalId, String date);

}
