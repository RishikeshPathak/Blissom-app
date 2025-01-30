package com.blissom.bookingservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blissom.bookingservice.dto.ServiceAnalyticsResponse;
import com.blissom.bookingservice.model.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, String> {

    BookingEntity save(BookingEntity bookingEntity);

    Optional findById(String bookingId);

    List<BookingEntity> findByUserId(String userId);

    List<BookingEntity> findByProfessionalId(String professionalId);

    int countByUserId(String userId);

    int countByProfessionalId(String professionalId);

    int countByStatus(String status);

    @Query("SELECT b FROM BookingEntity b WHERE b.createdAt >= ?1 AND b.createdAt <= ?2")
    List<BookingEntity> findAnalyticsData(String startDate, String endDate);

    @Query("SELECT COUNT(b.id) AS count, b.serviceId AS serviceId FROM BookingEntity b GROUP BY b.serviceId ORDER BY count DESC")
    List<ServiceAnalyticsResponse> findMostBookedServices(int limit);

    @Query("UPDATE BookingEntity b SET b.status = ?2 WHERE b.id IN ?1")
    boolean bulkUpdateStatuses(Object bookingIds, Object newStatus);

    @Query("SELECT b FROM BookingEntity b WHERE b.location = ?1 AND b.radius <= ?2")
    List<BookingEntity> findByLocationAndRadius(String location, double radius);

    @Query("SELECT b FROM BookingEntity b WHERE b.professionalId = ?1 AND b.scheduledTime >= ?2 AND b.scheduledTime <= ?3")
    List<BookingEntity> findByTimeRange(String professionalId, String startTime, String endTime);

}

