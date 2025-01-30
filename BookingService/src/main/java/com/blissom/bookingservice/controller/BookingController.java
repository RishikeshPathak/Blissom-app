package com.blissom.bookingservice.controller;

import com.blissom.bookingservice.dto.*;
import com.blissom.bookingservice.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Booking Management
    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest request) {
        return ResponseEntity.ok(bookingService.createBooking(request));
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<BookingResponse> updateBooking(@PathVariable String bookingId, @RequestBody BookingUpdateRequest request) {
        return ResponseEntity.ok(bookingService.updateBooking(bookingId, request));
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Boolean> cancelBooking(@PathVariable String bookingId, @RequestBody CancellationRequest request) {
        return ResponseEntity.ok(bookingService.cancelBooking(bookingId, request));
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable String bookingId) {
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingResponse>> getBookingsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
    }

    @GetMapping("/professional/{professionalId}")
    public ResponseEntity<List<BookingResponse>> getBookingsByProfessionalId(@PathVariable String professionalId) {
        return ResponseEntity.ok(bookingService.getBookingsByProfessionalId(professionalId));
    }

    // Booking Status Management
    @PatchMapping("/{bookingId}/status")
    public ResponseEntity<Boolean> updateBookingStatus(@PathVariable String bookingId, @RequestParam String newStatus) {
        return ResponseEntity.ok(bookingService.updateBookingStatus(bookingId, newStatus));
    }

    @GetMapping("/{bookingId}/status-history")
    public ResponseEntity<List<BookingStatusHistoryResponse>> getBookingStatusHistory(@PathVariable String bookingId) {
        return ResponseEntity.ok(bookingService.getBookingStatusHistory(bookingId));
    }

    // Scheduling
    @PatchMapping("/{bookingId}/reschedule")
    public ResponseEntity<Boolean> rescheduleBooking(@PathVariable String bookingId, @RequestBody RescheduleRequest request) {
        return ResponseEntity.ok(bookingService.rescheduleBooking(bookingId, request));
    }

    @GetMapping("/availability/{professionalId}")
    public ResponseEntity<List<BookingResponse>> getAvailableSlots(@PathVariable String professionalId, @RequestParam String date) {
        return ResponseEntity.ok(bookingService.getAvailableSlots(professionalId, date));
    }

    // Analytics and Reporting
    @GetMapping("/analytics/user/{userId}")
    public ResponseEntity<Integer> getTotalBookingsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(bookingService.getTotalBookingsByUserId(userId));
    }

    @GetMapping("/analytics/professional/{professionalId}")
    public ResponseEntity<Integer> getTotalBookingsByProfessionalId(@PathVariable String professionalId) {
        return ResponseEntity.ok(bookingService.getTotalBookingsByProfessionalId(professionalId));
    }

    @GetMapping("/analytics/status")
    public ResponseEntity<Integer> getTotalBookingsByStatus(@RequestParam String status) {
        return ResponseEntity.ok(bookingService.getTotalBookingsByStatus(status));
    }

    @GetMapping("/analytics")
    public ResponseEntity<List<BookingAnalyticsResponse>> getBookingAnalytics(@RequestParam String startDate, @RequestParam String endDate) {
        return ResponseEntity.ok(bookingService.getBookingAnalytics(startDate, endDate));
    }

    // Popular and Frequently Booked Services
    @GetMapping("/popular-services")
    public ResponseEntity<List<ServiceAnalyticsResponse>> getMostBookedServices(@RequestParam int limit) {
        return ResponseEntity.ok(bookingService.getMostBookedServices(limit));
    }

    // Bulk Operations
    @PatchMapping("/bulk-status-update")
    public ResponseEntity<Boolean> bulkUpdateBookingStatuses(@RequestBody BulkStatusUpdateRequest request) {
        return ResponseEntity.ok(bookingService.bulkUpdateBookingStatuses(request));
    }

    // Notifications and Updates
    @PostMapping("/{bookingId}/reminder")
    public ResponseEntity<Boolean> sendBookingReminder(@PathVariable String bookingId) {
        return ResponseEntity.ok(bookingService.sendBookingReminder(bookingId));
    }

    @PostMapping("/{bookingId}/notify-status")
    public ResponseEntity<Boolean> notifyStatusChange(@PathVariable String bookingId, @RequestParam String status) {
        return ResponseEntity.ok(bookingService.notifyStatusChange(bookingId, status));
    }

    // Location-Based Bookings
    @GetMapping("/location")
    public ResponseEntity<List<BookingResponse>> getBookingsByLocation(@RequestParam String location, @RequestParam double radius) {
        return ResponseEntity.ok(bookingService.getBookingsByLocation(location, radius));
    }

    // Advanced Features
    @GetMapping("/time-range")
    public ResponseEntity<List<BookingResponse>> getBookingsForTimeRange(@RequestParam String professionalId, @RequestParam String startTime, @RequestParam String endTime) {
        return ResponseEntity.ok(bookingService.getBookingsForTimeRange(professionalId, startTime, endTime));
    }

    @PatchMapping("/{bookingId}/complete")
    public ResponseEntity<Boolean> markBookingAsCompleted(@PathVariable String bookingId) {
        return ResponseEntity.ok(bookingService.markBookingAsCompleted(bookingId));
    }

    @PostMapping("/{bookingId}/refund")
    public ResponseEntity<Boolean> refundBooking(@PathVariable String bookingId, @RequestBody RefundRequest request) {
        return ResponseEntity.ok(bookingService.refundBooking(bookingId, request));
    }
}
