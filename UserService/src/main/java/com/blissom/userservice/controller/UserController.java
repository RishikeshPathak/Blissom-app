package com.blissom.userservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.blissom.userservice.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    // --- User Management ---

    @PostMapping
    public ResponseEntity<UserProfileResponse> createUser(@RequestBody UserProfileRequest request) {
        UserProfileResponse response = userService.createUser(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserProfileResponse> updateUser(@PathVariable String userId,
                                                          @RequestBody UserProfileRequest request) {
        UserProfileResponse response = userService.updateUser(userId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String userId) {
        boolean result = userService.deleteUser(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserProfileResponse> getUserById(@PathVariable String userId) {
        UserProfileResponse response = userService.getUserById(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserProfileResponse>> searchUsers(@RequestParam String keyword) {
        List<UserProfileResponse> response = userService.searchUsers(keyword);
        return ResponseEntity.ok(response);
    }

     // --- Address Management ---

     @PostMapping("/{userId}/addresses")
     public ResponseEntity<AddressResponse> addUserAddress(@PathVariable String userId,
                                                           @RequestBody AddressRequest request) {
         AddressResponse response = userService.addUserAddress(userId, request);
         return ResponseEntity.ok(response);
     }

     @PutMapping("/{userId}/addresses/{addressId}")
     public ResponseEntity<AddressResponse> updateUserAddress(@PathVariable String userId,
                                                              @PathVariable String addressId,
                                                              @RequestBody AddressRequest request) {
         AddressResponse response = userService.updateUserAddress(userId, addressId, request);
         return ResponseEntity.ok(response);
     }

     @DeleteMapping("/{userId}/addresses/{addressId}")
     public ResponseEntity<Boolean> deleteUserAddress(@PathVariable String userId,
                                                      @PathVariable String addressId) {
         boolean result = userService.deleteUserAddress(userId, addressId);
         return ResponseEntity.ok(result);
     }

     @GetMapping("/{userId}/addresses")
     public ResponseEntity<List<AddressResponse>> getUserAddresses(@PathVariable String userId) {
         List<AddressResponse> response = userService.getUserAddresses(userId);
         return ResponseEntity.ok(response);
     }

    // --- Preference Management ---

    @PutMapping("/{userId}/preferences")
    public ResponseEntity<PreferencesResponse> updateUserPreferences(@PathVariable String userId,
                                                                     @RequestBody PreferencesRequest request) {
        PreferencesResponse response = userService.updateUserPreferences(userId, request);
        return ResponseEntity.ok(response);
    }

     @GetMapping("/{userId}/preferences")
     public ResponseEntity<PreferencesResponse> getUserPreferences(@PathVariable String userId) {
         PreferencesResponse response = userService.getUserPreferences(userId);
         return ResponseEntity.ok(response);
     }

     // --- Loyalty Points ---

     @PostMapping("/{userId}/loyalty/add")
     public ResponseEntity<LoyaltyPointsResponse> addLoyaltyPoints(@PathVariable String userId,
                                                                   @RequestParam int points) {
         LoyaltyPointsResponse response = userService.addLoyaltyPoints(userId, points);
         return ResponseEntity.ok(response);
     }

     @PostMapping("/{userId}/loyalty/deduct")
     public ResponseEntity<LoyaltyPointsResponse> deductLoyaltyPoints(@PathVariable String userId,
                                                                      @RequestParam int points) {
         LoyaltyPointsResponse response = userService.deductLoyaltyPoints(userId, points);
         return ResponseEntity.ok(response);
     }

     @GetMapping("/{userId}/loyalty")
     public ResponseEntity<LoyaltyPointsResponse> getLoyaltyPoints(@PathVariable String userId) {
         LoyaltyPointsResponse response = userService.getLoyaltyPoints(userId);
         return ResponseEntity.ok(response);
     }

     // --- Account Security --

    @PostMapping("/{userId}/2fa/enable")
    public ResponseEntity<Boolean> enableTwoFactorAuth(@PathVariable String userId) {
        boolean result = userService.enableTwoFactorAuth(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{userId}/2fa/disable")
    public ResponseEntity<Boolean> disableTwoFactorAuth(@PathVariable String userId) {
        boolean result = userService.disableTwoFactorAuth(userId);
        return ResponseEntity.ok(result);
    }

	/*
	 * @PostMapping("/{userId}/reset-password") public ResponseEntity<Boolean>
	 * resetPassword(@PathVariable String userId,
	 * 
	 * @RequestBody ResetPasswordRequest request) { boolean result =
	 * userService.resetPassword(userId, request); return ResponseEntity.ok(result);
	 * }
	 */

    @PostMapping("/{userId}/verify-security-questions")
    public ResponseEntity<Boolean> verifySecurityQuestions(@PathVariable String userId,
                                                           @RequestBody SecurityQuestionRequest request) {
        boolean result = userService.verifySecurityQuestions(userId, request);
        return ResponseEntity.ok(result);
    }

    // --- Activity Logs ---

    @GetMapping("/{userId}/activity-logs")
    public ResponseEntity<List<ActivityLogResponse>> getActivityLogs(@PathVariable String userId) {
        List<ActivityLogResponse> response = userService.getActivityLogs(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{userId}/log-activity")
    public ResponseEntity<Void> logUserActivity(@PathVariable String userId, @RequestParam String action) {
        userService.logUserActivity(userId, action);
        return ResponseEntity.noContent().build();
    }

    // --- Account Status ---

    @PostMapping("/{userId}/lock")
    public ResponseEntity<Boolean> lockUserAccount(@PathVariable String userId) {
        boolean result = userService.lockUserAccount(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{userId}/unlock")
    public ResponseEntity<Boolean> unlockUserAccount(@PathVariable String userId) {
        boolean result = userService.unlockUserAccount(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{userId}/suspend")
    public ResponseEntity<Boolean> suspendUserAccount(@PathVariable String userId,
                                                      @RequestParam String reason) {
        boolean result = userService.suspendUserAccount(userId, reason);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{userId}/activate")
    public ResponseEntity<Boolean> activateUserAccount(@PathVariable String userId) {
        boolean result = userService.activateUserAccount(userId);
        return ResponseEntity.ok(result);
    }

    // --- Referral System ---

    @GetMapping("/{userId}/generate-referral")
    public ResponseEntity<String> generateReferralCode(@PathVariable String userId) {
        String referralCode = userService.generateReferralCode(userId);
        return ResponseEntity.ok(referralCode);
    }

    @PostMapping("/{userId}/apply-referral")
    public ResponseEntity<Boolean> applyReferralCode(@PathVariable String userId,
                                                      @RequestParam String referralCode) {
        boolean result = userService.applyReferralCode(userId, referralCode);
        return ResponseEntity.ok(result);
    }

    // --- GDPR Compliance ---

    @PostMapping("/{userId}/anonymize")
    public ResponseEntity<Boolean> anonymizeUserData(@PathVariable String userId) {
        boolean result = userService.anonymizeUserData(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{userId}/export-data")
    public ResponseEntity<Boolean> exportUserData(@PathVariable String userId) {
        boolean result = userService.exportUserData(userId);
        return ResponseEntity.ok(result);
    }

    // --- Analytics ---

//    @GetMapping("/top-active-users")
//    public ResponseEntity<List<UserProfileResponse>> getTopUsersByActivity(@RequestParam int limit) {
//        List<UserProfileResponse> response = userService.getTopUsersByActivity(limit);
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/count-by-status")
    public ResponseEntity<Integer> getUserCountByStatus(@RequestParam String status) {
        int count = userService.getUserCountByStatus(status);
        return ResponseEntity.ok(count);
    }
}
