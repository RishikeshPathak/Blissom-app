package com.blissom.userservice.service;



import java.util.List;

import com.blissom.userservice.dto.ActivityLogResponse;
import com.blissom.userservice.dto.AddressRequest;
import com.blissom.userservice.dto.AddressResponse;
import com.blissom.userservice.dto.LoyaltyPointsResponse;
import com.blissom.userservice.dto.PreferencesRequest;
import com.blissom.userservice.dto.PreferencesResponse;
import com.blissom.userservice.dto.ResetPasswordRequest;
import com.blissom.userservice.dto.SecurityQuestionRequest;
import com.blissom.userservice.dto.UserProfileRequest;
import com.blissom.userservice.dto.UserProfileResponse;

public interface UserService {

    // User Management
    UserProfileResponse createUser(UserProfileRequest request);
    UserProfileResponse updateUser(String userId, UserProfileRequest request);
    boolean deleteUser(String userId); // Soft delete
    UserProfileResponse getUserById(String userId);
    List<UserProfileResponse> searchUsers(String keyword); // Search by name, email, or phone

    // Address Management
    AddressResponse addUserAddress(String userId, AddressRequest request);
    AddressResponse updateUserAddress(String userId, String addressId, AddressRequest request);
    boolean deleteUserAddress(String userId, String addressId);
    List<AddressResponse> getUserAddresses(String userId);

    // Preference Management
    PreferencesResponse updateUserPreferences(String userId, PreferencesRequest request);
    PreferencesResponse getUserPreferences(String userId);

    // Loyalty Points
    LoyaltyPointsResponse addLoyaltyPoints(String userId, int points);
    LoyaltyPointsResponse deductLoyaltyPoints(String userId, int points);
    LoyaltyPointsResponse getLoyaltyPoints(String userId);

    // Account Security
    boolean enableTwoFactorAuth(String userId);
    boolean disableTwoFactorAuth(String userId);
   // boolean resetPassword(String userId, ResetPasswordRequest request);
    boolean verifySecurityQuestions(String userId, SecurityQuestionRequest request);
//
    // Activity Logs
    List<ActivityLogResponse> getActivityLogs(String userId);
    void logUserActivity(String userId, String action);
//
    // Account Status
    boolean lockUserAccount(String userId);
    boolean unlockUserAccount(String userId);
    boolean suspendUserAccount(String userId, String reason);
    boolean activateUserAccount(String userId);
//
    // Referral System
    String generateReferralCode(String userId);
    boolean applyReferralCode(String userId, String referralCode);
//
    // GDPR Compliance
    boolean anonymizeUserData(String userId);
    boolean exportUserData(String userId);
//
    // Analytics
   // List<UserProfileResponse> getTopUsersByActivity(int limit);
    int getUserCountByStatus(String status);
}
