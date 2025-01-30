package com.blissom.bookingservice.mapper;

import java.time.LocalDateTime;

import com.blissom.bookingservice.dto.BookingRequest;
import com.blissom.bookingservice.dto.BookingResponse;
import com.blissom.bookingservice.dto.BookingUpdateRequest;
import com.blissom.bookingservice.model.AvailabilityEntity;
import com.blissom.bookingservice.model.BookingEntity;
import com.blissom.bookingservice.model.Timer;

import reactor.core.publisher.Timed;

public class BookingMapper {

    public static BookingEntity toEntity(BookingRequest request){
        BookingEntity entity = new BookingEntity();
        entity.setUserId(request.getUserId());
        entity.setProfessionalId(request.getProfessionalId());
        entity.setAvailability(request.getAvailability());
        return entity;
    }

    public static BookingResponse toResponse(BookingEntity entity){
        BookingResponse response = new BookingResponse();
        response.setBookingId(entity.getBookingId());
        response.setUserId(entity.getUserId());
        response.setProfessionalId(entity.getProfessionalId());
        response.setScheduledTime(entity.getScheduledTime());
        response.setStatus(entity.getStatus());
        response.setServiceName(entity.getServiceName());
        return response;
    }

    public static BookingEntity toEntity(BookingUpdateRequest request){
        BookingEntity entity = new BookingEntity();
        entity.setBookingId(request.getBookingId());
        entity.setUserId(request.getUserId());
        entity.setProfessionalId(request.getProfessionalId());
        entity.setAvailability(request.getAvailability());
        entity.setStatus(request.getStatus());
        entity.setServiceName(request.getServiceName());
        return entity;
    }

    public void updateEntityFromRequest(BookingUpdateRequest request, BookingEntity bookingEntity) {
        bookingEntity.setUserId(request.getUserId());
        bookingEntity.setProfessionalId(request.getProfessionalId());
        bookingEntity.setAvailability(request.getAvailability());
        bookingEntity.setStatus(request.getStatus());
        bookingEntity.setServiceName(request.getServiceName());
    }

    public static BookingResponse toResponseFromSlot(AvailabilityEntity slot) {
    BookingResponse response = new BookingResponse();
    Timer timeSlot = slot.getTimeSlots().get(0);
    response.setScheduledTime(slot.getDate().atTime(timeSlot.getStartTime().toLocalTime()));
    response.setServiceName(slot.getServiceName());
    return response;
}

}

