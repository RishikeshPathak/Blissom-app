package com.blissom.bookingservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "booking_status_history")
public class BookingStatusHistoryEntity {

    @Id
    private String bookingStatusHistoryId;

    private String bookingId;
    private String status;
    private LocalDateTime timestamp;

   

    public String getBookingStatusHistoryId() {
		return bookingStatusHistoryId;
	}

	public void setBookingStatusHistoryId(String bookingStatusHistoryId) {
		this.bookingStatusHistoryId = bookingStatusHistoryId;
	}

	public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}

