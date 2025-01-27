package com.blissom.userservice.mapper;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.blissom.userservice.dto.UserProfileRequest;
import com.blissom.userservice.dto.UserProfileResponse;
import com.blissom.userservice.model.UserEntity;

@Component
public class UserMapper {

    public UserProfileResponse mapToUserProfileResponse(UserEntity userEntity) {
        UserProfileResponse userProfileResponse = new UserProfileResponse();
        userProfileResponse.setUserId(userEntity.getUserId());
        userProfileResponse.setFirstName(userEntity.getFirstName());
        userProfileResponse.setLastName(userEntity.getLastName());
        userProfileResponse.setUserName(userEntity.getUserName());
        userProfileResponse.setMobileNumber(userEntity.getMobileNumber());
        userProfileResponse.setEmail(userEntity.getEmail());
        userProfileResponse.setDateOfBirth(userEntity.getDateOfBirth());
        userProfileResponse.setGender(userEntity.getGender());
        userProfileResponse.setCountryCode(userEntity.getCountryCode());
        userProfileResponse.setProfilePicture(userEntity.getProfilePictureSmall());
        userProfileResponse.setProfilePictureSmall(userEntity.getProfilePictureSmall());
        userProfileResponse.setMaritalStatus(userEntity.getMaritalStatus());
        userProfileResponse.setNationality(userEntity.getNationality());
        userProfileResponse.setOccupation(userEntity.getOccupation());
        userProfileResponse.setAboutMe(userEntity.getAboutMe());
        userProfileResponse.setCreatedAt(userEntity.getCreatedAt());
        userProfileResponse.setUpdatedAt(userEntity.getUpdatedAt());
        userProfileResponse.setDeleted(Boolean.TRUE.equals(userEntity.getDeleted()));
        userProfileResponse.setDeleted(userEntity.getDeleted());
        return userProfileResponse;
    }

    public UserEntity mapToUserEntity(UserProfileRequest userProfileRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userProfileRequest.getUserId());
        userEntity.setFirstName(userProfileRequest.getFirstName());
        userEntity.setLastName(userProfileRequest.getLastName());
        userEntity.setUserName(userProfileRequest.getUserName());
        userEntity.setMobileNumber(userProfileRequest.getMobileNumber());
        userEntity.setEmail(userProfileRequest.getEmail());
        userEntity.setDateOfBirth(userProfileRequest.getDateOfBirth());
        userEntity.setGender(userProfileRequest.getGender());
        userEntity.setCountryCode(userProfileRequest.getCountryCode());
        userEntity.setProfilePicture(userProfileRequest.getProfilePictureSmall());
        userEntity.setProfilePictureSmall(userProfileRequest.getProfilePictureSmall());
        userEntity.setMaritalStatus(userProfileRequest.getMaritalStatus());
        userEntity.setNationality(userProfileRequest.getNationality());
        userEntity.setOccupation(userProfileRequest.getOccupation());
        userEntity.setAboutMe(userProfileRequest.getAboutMe());
        userEntity.setCreatedAt(userProfileRequest.getCreatedAt());
        userEntity.setUpdatedAt(userProfileRequest.getUpdatedAt());
        userEntity.setDeleted(Boolean.TRUE.equals(userProfileRequest.getDeleted()));
        userEntity.setDeleted(userProfileRequest.getDeleted());
        return userEntity;
    }

    public List<UserProfileResponse> mapToUserProfileResponseList(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(this::mapToUserProfileResponse)
                .collect(Collectors.toList());
    }

    public List<UserEntity> mapToUserEntityList(List<UserProfileRequest> userProfileRequests) {
        return userProfileRequests.stream()
                .map(this::mapToUserEntity)
                .collect(Collectors.toList());
    }

    public static UserProfileResponse toUserProfileResponse(UserEntity user) {
        UserProfileResponse userProfileResponse = new UserProfileResponse();
        userProfileResponse.setUserId(user.getUserId());
        userProfileResponse.setFirstName(user.getFirstName());
        userProfileResponse.setLastName(user.getLastName());
        userProfileResponse.setUserName(user.getUserName());
        userProfileResponse.setMobileNumber(user.getMobileNumber());
        userProfileResponse.setEmail(user.getEmail());
        userProfileResponse.setDateOfBirth(user.getDateOfBirth());
        userProfileResponse.setGender(user.getGender());
        userProfileResponse.setCountryCode(user.getCountryCode());
        userProfileResponse.setProfilePicture(user.getProfilePicture());
        userProfileResponse.setProfilePictureSmall(user.getProfilePictureSmall());
        userProfileResponse.setMaritalStatus(user.getMaritalStatus());
        userProfileResponse.setNationality(user.getNationality());
        userProfileResponse.setOccupation(user.getOccupation());
        userProfileResponse.setAboutMe(user.getAboutMe());
        userProfileResponse.setCreatedAt(user.getCreatedAt());
        userProfileResponse.setUpdatedAt(user.getUpdatedAt());
        userProfileResponse.setDeleted(Boolean.TRUE.equals(user.getDeleted()));
        return userProfileResponse;
    }
}
