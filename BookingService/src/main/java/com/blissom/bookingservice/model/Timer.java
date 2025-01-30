package com.blissom.bookingservice.model;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "timer")
public class Timer {

    @Id
    private String timerId;

    private LocalDateTime startTime;

    @ManyToOne
    @JoinColumn(name = "availability_id", nullable = false)
    private AvailabilityEntity availability;

    public Timer() {
        this.timerId = UUID.randomUUID().toString();
    }

    public Timer(LocalDateTime startTime, AvailabilityEntity availability) {
        this();
        this.startTime = startTime;
        this.availability = availability;
    }

	public String getTimerId() {
		return timerId;
	}

	public void setTimerId(String timerId) {
		this.timerId = timerId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public AvailabilityEntity getAvailability() {
		return availability;
	}

	public void setAvailability(AvailabilityEntity availability) {
		this.availability = availability;
	}
    
    
}
