package com.blissom.bookingservice.service;


import java.util.List;

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

public interface BookingService {

    // Booking Management
    BookingResponse createBooking(BookingRequest request);
    BookingResponse updateBooking(String bookingId, BookingUpdateRequest request);
    boolean cancelBooking(String bookingId, CancellationRequest request);
    BookingResponse getBookingById(String bookingId);
    List<BookingResponse> getBookingsByUserId(String userId);
    List<BookingResponse> getBookingsByProfessionalId(String professionalId);

    // Booking Status Management
    boolean updateBookingStatus(String bookingId, String newStatus); // 'Pending', 'Confirmed', etc.
    List<BookingStatusHistoryResponse> getBookingStatusHistory(String bookingId);

    // Scheduling
    boolean rescheduleBooking(String bookingId, RescheduleRequest request);
    List<BookingResponse> getAvailableSlots(String professionalId, String date); // Retrieves available booking slots

    // Analytics and Reporting
    int getTotalBookingsByUserId(String userId);
    int getTotalBookingsByProfessionalId(String professionalId);
    int getTotalBookingsByStatus(String status);
    List<BookingAnalyticsResponse> getBookingAnalytics(String startDate, String endDate);

    // Popular and Frequently Booked Services
    List<ServiceAnalyticsResponse> getMostBookedServices(int limit);

    // Bulk Operations
    boolean bulkUpdateBookingStatuses(BulkStatusUpdateRequest request);

    // Notifications and Updates
    boolean sendBookingReminder(String bookingId);
    boolean notifyStatusChange(String bookingId, String status);

    // Location-Based Bookings
    List<BookingResponse> getBookingsByLocation(String location, double radius);

    // Advanced Features
    List<BookingResponse> getBookingsForTimeRange(String professionalId, String startTime, String endTime); // Fetch bookings in a specific time range
    boolean markBookingAsCompleted(String bookingId);
    boolean refundBooking(String bookingId, RefundRequest request);
}
