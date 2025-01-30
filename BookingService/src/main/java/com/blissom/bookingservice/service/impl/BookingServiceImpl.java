package com.blissom.bookingservice.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blissom.bookingservice.dto.BookingAnalyticsResponse;
import com.blissom.bookingservice.dto.BookingRequest;
import com.blissom.bookingservice.dto.BookingResponse;
import com.blissom.bookingservice.dto.BookingStatusHistoryResponse;
import com.blissom.bookingservice.dto.BookingUpdateRequest;
import com.blissom.bookingservice.dto.BulkStatusUpdateRequest;
import com.blissom.bookingservice.dto.CancellationRequest;
import com.blissom.bookingservice.dto.RefundRequest;
import com.blissom.bookingservice.dto.RescheduleRequest;
import com.blissom.bookingservice.dto.ServiceAnalyticsResponse;
import com.blissom.bookingservice.mapper.BookingAnalyticsMapper;
import com.blissom.bookingservice.mapper.BookingMapper;
import com.blissom.bookingservice.model.AvailabilityEntity;
import com.blissom.bookingservice.model.BookingEntity;
import com.blissom.bookingservice.model.BookingStatusHistoryEntity;
import com.blissom.bookingservice.repository.BookingRepository;
import com.blissom.bookingservice.repository.BookingStatusHistoryRepository;
import com.blissom.bookingservice.repository.ProfessionalAvailabilityRepository;
import com.blissom.bookingservice.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ProfessionalAvailabilityRepository availabilityRepository;

    @Autowired
    private BookingStatusHistoryRepository statusHistoryRepository;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private BookingAnalyticsMapper analyticsMapper;

    // --- Booking Management ---

    @Override
    public BookingResponse createBooking(BookingRequest request) {
        BookingEntity bookingEntity = bookingMapper.toEntity(request);
        bookingEntity.setBookingId(UUID.randomUUID().toString());
        bookingEntity.setStatus("Pending");
        bookingEntity.setCreatedAt(LocalDateTime.now());
        bookingRepository.save(bookingEntity);
        return bookingMapper.toResponse(bookingEntity);
    }

    @Override
    public BookingResponse updateBooking(String bookingId, BookingUpdateRequest request) {
        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
        BookingEntity bookingEntity = optionalBookingEntity.orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        
        bookingMapper.updateEntityFromRequest(request, bookingEntity);
        bookingRepository.save(bookingEntity);
        return bookingMapper.toResponse(bookingEntity);
    }

    @Override
    public boolean cancelBooking(String bookingId, CancellationRequest request) {
        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
        BookingEntity bookingEntity = optionalBookingEntity.orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        
        bookingEntity.setStatus("Cancelled");
        bookingEntity.setCancellationReason(request.getReason());
        bookingRepository.save(bookingEntity);

        logStatusChange(bookingEntity, "Cancelled");
        return true;
    }

    @Override
    public BookingResponse getBookingById(String bookingId) {
        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
        BookingEntity bookingEntity = optionalBookingEntity.orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        
        return bookingMapper.toResponse(bookingEntity);
    }

    @Override
    public List<BookingResponse> getBookingsByUserId(String userId) {
        List<BookingEntity> bookings = bookingRepository.findByUserId(userId);
        return bookings.stream().map(BookingMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<BookingResponse> getBookingsByProfessionalId(String professionalId) {
        List<BookingEntity> bookings = bookingRepository.findByProfessionalId(professionalId);
        return bookings.stream().map(BookingMapper::toResponse).collect(Collectors.toList());
    }

    // --- Booking Status Management ---

    @Override
    public boolean updateBookingStatus(String bookingId, String newStatus) {
        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
        BookingEntity bookingEntity = optionalBookingEntity.orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        
        bookingEntity.setStatus(newStatus);
        bookingRepository.save(bookingEntity);

        logStatusChange(bookingEntity, newStatus);
        return true;
    }

    @Override
    public List<BookingStatusHistoryResponse> getBookingStatusHistory(String bookingId) {
        return statusHistoryRepository.findByBookingId(bookingId).stream()
                .map(entity -> {
                    BookingStatusHistoryResponse response = new BookingStatusHistoryResponse();
                    response.setId(entity.getBookingStatusHistoryId());
                    response.setBookingId(entity.getBookingId());
                    response.setStatus(entity.getStatus());
                    response.setTimestamp(entity.getTimestamp());
                    return response;
                })
                .collect(Collectors.toList());
    }

    // --- Scheduling ---

    @Override
    public boolean rescheduleBooking(String bookingId, RescheduleRequest request) {
        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
        BookingEntity bookingEntity = optionalBookingEntity.orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        

        bookingEntity.setScheduledTime(request.getNewScheduledTime());
        bookingEntity.setStatus("Rescheduled");
        bookingRepository.save(bookingEntity);

        logStatusChange(bookingEntity, "Rescheduled");
        return true;
    }

    @Override
    public List<BookingResponse> getAvailableSlots(String professionalId, String date) {
        List<AvailabilityEntity> availableSlots = availabilityRepository.findAvailableSlots(professionalId, date);
        return availableSlots.stream()
                .map(slot -> BookingMapper.toResponseFromSlot(slot))
                .collect(Collectors.toList());
    }

    // --- Analytics and Reporting ---

    @Override
    public int getTotalBookingsByUserId(String userId) {
        return bookingRepository.countByUserId(userId);
    }

    @Override
    public int getTotalBookingsByProfessionalId(String professionalId) {
        return bookingRepository.countByProfessionalId(professionalId);
    }

    @Override
    public int getTotalBookingsByStatus(String status) {
        return bookingRepository.countByStatus(status);
    }

    @Override
    public List<BookingAnalyticsResponse> getBookingAnalytics(String startDate, String endDate) {
        List<BookingEntity> bookings = bookingRepository.findAnalyticsData(startDate, endDate);
        return bookings.stream()
                .map(bookingEntity -> {
                    BookingAnalyticsResponse response = new BookingAnalyticsResponse();
                    response.setDate(bookingEntity.getCreatedAt().toLocalDate());
                    response.setCount("1");
                    response.setProfessionalId(bookingEntity.getProfessionalId());
                    response.setProfessionalName(bookingEntity.getProfessionalName());
                    response.setServiceName(bookingEntity.getServiceName());
                    response.setStatus(bookingEntity.getStatus());
                    return response;
                })
                .collect(Collectors.toList());
    }

    // --- Popular and Frequently Booked Services ---

    @Override
    public List<ServiceAnalyticsResponse> getMostBookedServices(int limit) {
        return bookingRepository.findMostBookedServices(limit);
    }

    // --- Bulk Operations ---

    @Override
    public boolean bulkUpdateBookingStatuses(BulkStatusUpdateRequest request) {
        return bookingRepository.bulkUpdateStatuses(request.getBookingIds(), request.getNewStatus());
    }

    // --- Notifications and Updates ---

    @Override
    public boolean sendBookingReminder(String bookingId) {
        // Logic for sending reminders (e.g., via email or SMS)
        return true;
    }

    @Override
    public boolean notifyStatusChange(String bookingId, String status) {
        // Logic for notifying users of status changes
        return true;
    }

    // --- Location-Based Bookings ---

    @Override
    public List<BookingResponse> getBookingsByLocation(String location, double radius) {
        List<BookingEntity> bookings = bookingRepository.findByLocationAndRadius(location, radius);
        return bookings.stream().map(BookingMapper::toResponse).collect(Collectors.toList());
    }

    // --- Advanced Features ---

    @Override
    public List<BookingResponse> getBookingsForTimeRange(String professionalId, String startTime, String endTime) {
        List<BookingEntity> bookings = bookingRepository.findByTimeRange(professionalId, startTime, endTime);
        return bookings.stream().map(BookingMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public boolean markBookingAsCompleted(String bookingId) {
        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
        BookingEntity bookingEntity = optionalBookingEntity.orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        bookingEntity.setStatus("Completed");
        bookingRepository.save(bookingEntity);

        logStatusChange(bookingEntity, "Completed");
        return true;
    }

    @Override
    public boolean refundBooking(String bookingId, RefundRequest request) {
        Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
        BookingEntity bookingEntity = optionalBookingEntity.orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        bookingEntity.setRefundDetails(request.getRefundReason());
        bookingEntity.setStatus("Refunded");
        bookingRepository.save(bookingEntity);

        logStatusChange(bookingEntity, "Refunded");
        return true;
    }

    // --- Helper Methods ---

    private void logStatusChange(BookingEntity bookingEntity, String newStatus) {
        BookingStatusHistoryEntity history = new BookingStatusHistoryEntity();
        history.setBookingId(bookingEntity.getBookingId());
        history.setStatus(newStatus);
        history.setTimestamp(LocalDateTime.now());
        statusHistoryRepository.save(history);
    }
}
