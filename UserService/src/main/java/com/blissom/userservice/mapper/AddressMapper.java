package com.blissom.userservice.mapper;

import com.blissom.userservice.dto.AddressResponse;
import com.blissom.userservice.model.AddressEntity;

public class AddressMapper {

    public static AddressResponse toAddressResponse(AddressEntity address) {
        AddressResponse response = new AddressResponse();
        response.setAddressId(address.getAddressId());
        response.setUserId(address.getUserId().getUserId());
        response.setStreet(address.getStreet());
        response.setCity(address.getCity());
        response.setState(address.getState());
        response.setCountry(address.getCountry());
        response.setZipCode(address.getZipCode());
        response.setCreatedAt(address.getCreatedAt());
        response.setUpdatedAt(address.getUpdatedAt());
        return response;
    }

}
