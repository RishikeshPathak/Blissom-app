package com.blissom.bookingservice.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.blissom.bookingservice.dto.BookingAnalyticsResponse;
import com.blissom.bookingservice.model.BookingEntity;

@Component
public class BookingAnalyticsMapper {

    public List<BookingAnalyticsResponse> toResponse(List<BookingEntity> bookingEntities) {
        return bookingEntities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private BookingAnalyticsResponse toResponse(BookingEntity bookingEntity) {
        BookingAnalyticsResponse response = new BookingAnalyticsResponse();
        response.setDate(bookingEntity.getCreatedAt().toLocalDate());
        response.setCount("1");
        return response;
    }

}
