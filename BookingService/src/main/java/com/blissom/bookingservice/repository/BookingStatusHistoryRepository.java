package com.blissom.bookingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blissom.bookingservice.model.BookingStatusHistoryEntity;

public interface BookingStatusHistoryRepository extends JpaRepository<BookingStatusHistoryEntity, String> {

    @Query("SELECT b FROM BookingStatusHistoryEntity b WHERE b.bookingId = ?1")
    List<BookingStatusHistoryEntity> findByBookingId(String bookingId);

}

