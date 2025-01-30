package com.blissom.bookingservice.dto;

import com.blissom.bookingservice.model.AvailabilityEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {

    private String userId;
    private String professionalId;
    private AvailabilityEntity availability;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(String professionalId) {
        this.professionalId = professionalId;
    }

    public AvailabilityEntity getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilityEntity availability) {
        this.availability = availability;
    }
}

