package com.blissom.bookingservice.dto;

import com.blissom.bookingservice.model.AvailabilityEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingUpdateRequest {
    private String bookingId;
    private String userId;
    private String professionalId;
    private String status;
    private String serviceName;
    private String cancellationReason;
    private String refundDetails;
    private Object newScheduledTime;
    
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public String getRefundDetails() {
        return refundDetails;
    }

    public void setRefundDetails(String refundDetails) {
        this.refundDetails = refundDetails;
    }

    public Object getNewScheduledTime() {
        return newScheduledTime;
    }

    public void setNewScheduledTime(Object newScheduledTime) {
        this.newScheduledTime = newScheduledTime;
    }

    public AvailabilityEntity getAvailability() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAvailability'");
    }
}

