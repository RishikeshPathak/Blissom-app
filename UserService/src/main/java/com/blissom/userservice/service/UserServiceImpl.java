package com.blissom.userservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blissom.userservice.dataexporter.UserDataExporter;
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
import com.blissom.userservice.exception.ResourceNotFoundException;
import com.blissom.userservice.mapper.ActivityLogMapper;
import com.blissom.userservice.mapper.AddressMapper;
import com.blissom.userservice.mapper.LoyaltyPointsMapper;
import com.blissom.userservice.mapper.PreferencesMapper;
import com.blissom.userservice.mapper.UserMapper;
import com.blissom.userservice.model.ActivityLogEntity;
import com.blissom.userservice.model.AddressEntity;
import com.blissom.userservice.model.LoyaltyPointsEntity;
import com.blissom.userservice.model.PreferencesEntity;
import com.blissom.userservice.model.SecurityQuestionEntity;
import com.blissom.userservice.model.UserEntity;
import com.blissom.userservice.repository.ActivityLogRepository;
import com.blissom.userservice.repository.AddressRepository;
import com.blissom.userservice.repository.LoyaltyPointsRepository;
import com.blissom.userservice.repository.PreferencesRepository;
import com.blissom.userservice.repository.SecurityQuestionRepository;
import com.blissom.userservice.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PreferencesRepository preferencesRepository;

    @Autowired
    private LoyaltyPointsRepository loyaltyPointsRepository;

    @Autowired
    private ActivityLogRepository activityLogRepository;
    @Autowired
    private SecurityQuestionRepository securityQuestionRepository;

//    private final PasswordEncoder passwordEncoder;
//    @Autowired
//    public UserServiceImpl(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    // --- User Management ---

    @Override
    public UserProfileResponse createUser(UserProfileRequest request) {
        UserEntity user = new UserEntity();
        user.setUserId(UUID.randomUUID().toString());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setMobileNumber(request.getMobileNumber());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setGender(request.getGender());
        user.setCountryCode(request.getCountryCode());
        user.setProfilePictureSmall(request.getProfilePictureSmall());
        user.setMaritalStatus(request.getMaritalStatus());
        user.setNationality(request.getNationality());
        user.setOccupation(request.getOccupation());
        user.setAboutMe(request.getAboutMe());
        user.setProfilePicture(request.getProfilePicture());
        user.setCreatedAt(LocalDateTime.now());
        user.setAccountStatus("Active");

        userRepository.save(user);
        return UserMapper.toUserProfileResponse(user);
    }

    @Override
    public UserProfileResponse updateUser(String userId, UserProfileRequest request) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

                user.setFirstName(request.getFirstName());
                user.setLastName(request.getLastName());
                user.setEmail(request.getEmail());
                user.setMobileNumber(request.getMobileNumber());
                user.setDateOfBirth(request.getDateOfBirth());
                user.setGender(request.getGender());
                user.setCountryCode(request.getCountryCode());
                user.setProfilePictureSmall(request.getProfilePictureSmall());
                user.setMaritalStatus(request.getMaritalStatus());
                user.setNationality(request.getNationality());
                user.setOccupation(request.getOccupation());
                user.setAboutMe(request.getAboutMe());
                user.setProfilePicture(request.getProfilePicture());
                user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);
        return UserMapper.toUserProfileResponse(user);
    }

    @Override
    public boolean deleteUser(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setAccountStatus("Deleted");
        userRepository.save(user);
        return true;
    }

    @Override
    public UserProfileResponse getUserById(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return UserMapper.toUserProfileResponse(user);
    }

    @Override
    public List<UserProfileResponse> searchUsers(String keyword) {
        List<UserEntity> users = userRepository.searchByKeyword(keyword);
        return users.stream()
                .map(UserMapper::toUserProfileResponse)
                .collect(Collectors.toList());
    }

    // --- Address Management ---

    @Override
    public AddressResponse addUserAddress(String userId, AddressRequest request) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        AddressEntity address = new AddressEntity();
        address.setUserId(user);
        address.setAddressId(UUID.randomUUID().toString());
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setCountry(request.getCountry());
        address.setZipCode(request.getZipCode());
        address.setCreatedAt(LocalDateTime.now());

        addressRepository.save(address);
        return AddressMapper.toAddressResponse(address);
  }

    @Override
    public AddressResponse updateUserAddress(String userId, String addressId, AddressRequest request) {
        AddressEntity address = addressRepository.findById(addressId)
                .orElseThrow(() -> new IllegalArgumentException("Address not found"));

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setCountry(request.getCountry());
        address.setZipCode(request.getZipCode());
        address.setUpdatedAt(LocalDateTime.now());

        addressRepository.save(address);
        return AddressMapper.toAddressResponse(address);
    }

    @Override
    public boolean deleteUserAddress(String userId, String addressId) {
        AddressEntity address = addressRepository.findById(addressId)
                .orElseThrow(() -> new IllegalArgumentException("Address not found"));

        addressRepository.delete(address);
        return true;
    }

    @Override
    public List<AddressResponse> getUserAddresses(String userId) {
        List<AddressEntity> addresses = addressRepository.findByUserId(userId);
        return addresses.stream()
                .map(AddressMapper::toAddressResponse)
                .collect(Collectors.toList());
    }
    // --- Preference Management ---

    @Override
    public PreferencesResponse updateUserPreferences(String userId, PreferencesRequest request) {
        PreferencesEntity preferences = preferencesRepository.findByUserIdQuery(userId)
                .orElseGet(PreferencesEntity::new);

        preferences.setUserId(userId);
        preferences.setPreferencesId(UUID.randomUUID().toString());
        preferences.setTheme(request.getTheme());
        preferences.setLanguage(request.getLanguage());
        preferences.setNotificationsEnabled(request.isNotificationsEnabled());


        preferencesRepository.save(preferences);
        return PreferencesMapper.toPreferencesResponse(preferences);
    }
//    @Override
    public PreferencesResponse getUserPreferences(String userId) {
        PreferencesEntity preferences = preferencesRepository.findByUserIdQuery(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Preferences not found"));

        return PreferencesMapper.toPreferencesResponse(preferences);
    }

    // --- Loyalty Points ---

    @Override
    public LoyaltyPointsResponse addLoyaltyPoints(String userId, int points) {
        LoyaltyPointsEntity loyaltyPoints = loyaltyPointsRepository.findByUserId(userId)
                .orElseGet(() -> {
                    LoyaltyPointsEntity newLoyaltyPoints = new LoyaltyPointsEntity(userId, 0);
                    newLoyaltyPoints.setLoyaltyPointsId(UUID.randomUUID().toString());
                    return newLoyaltyPoints;
                });

        loyaltyPoints.addPoints(points);
        loyaltyPointsRepository.save(loyaltyPoints);
        return LoyaltyPointsMapper.toLoyaltyPointsResponse(loyaltyPoints);
    }

    @Override
    public LoyaltyPointsResponse deductLoyaltyPoints(String userId, int points) {
        LoyaltyPointsEntity loyaltyPoints = loyaltyPointsRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("No loyalty points found"));

        loyaltyPoints.deductPoints(points);
        loyaltyPointsRepository.save(loyaltyPoints);
        return LoyaltyPointsMapper.toLoyaltyPointsResponse(loyaltyPoints);
    }

    @Override
    public LoyaltyPointsResponse getLoyaltyPoints(String userId) {
        LoyaltyPointsEntity loyaltyPoints = loyaltyPointsRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("No loyalty points found"));

        return LoyaltyPointsMapper.toLoyaltyPointsResponse(loyaltyPoints);
    }
    @Override
    public boolean enableTwoFactorAuth(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setTwoFactorEnabled(true);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean disableTwoFactorAuth(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setTwoFactorEnabled(false);
        userRepository.save(user);
        return true;
    }

	/*
	 * @Override public boolean resetPassword(String userId, ResetPasswordRequest
	 * request) { UserEntity user = userRepository.findById(userId) .orElseThrow(()
	 * -> new IllegalArgumentException("User not found"));
	 * 
	 * if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
	 * throw new IllegalArgumentException("Old password does not match"); }
	 * 
	 * user.setPassword(passwordEncoder.encode(request.getNewPassword()));
	 * userRepository.save(user); return true; }
	 */

    @Override
    public boolean verifySecurityQuestions(String userId, SecurityQuestionRequest request) {
        SecurityQuestionEntity securityQuestion = securityQuestionRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Security questions not found"));

        return securityQuestion.getAnswers().equals(request.getAnswers());
    }

    @Override
    public List<ActivityLogResponse> getActivityLogs(String userId) {
        List<ActivityLogEntity> logs = activityLogRepository.findByUser_UserId(userId);
        return logs.stream()
                .map(ActivityLogMapper::toActivityLogResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void logUserActivity(String userId, String action) {
        ActivityLogEntity log = new ActivityLogEntity();
        log.setUserId(userId);
        log.setAction(action);
        log.setLogId(UUID.randomUUID().toString());
        log.setTimestamp(LocalDateTime.now());

        activityLogRepository.save(log);
    }

    @Override
    public boolean lockUserAccount(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setAccountLocked(true);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean unlockUserAccount(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setAccountLocked(false);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean suspendUserAccount(String userId, String reason) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setAccountStatus("Suspended");
        user.setSuspensionReason(reason);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean activateUserAccount(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setAccountStatus("Active");
        userRepository.save(user);
        return true;
    }

    @Override
    public String generateReferralCode(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        String referralCode = "REF-" + userId + "-" + System.currentTimeMillis();
        user.setReferralCode(referralCode);
        userRepository.save(user);
        return referralCode;
    }

    @Override
    public boolean applyReferralCode(String userId, String referralCode) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (userRepository.existsByReferralCode(referralCode)) {
            user.setUsedReferralCode(referralCode);
            userRepository.save(user);
            return true;
        }
        throw new IllegalArgumentException("Invalid referral code");
    }

    @Override
    public boolean anonymizeUserData(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setEmail("anonymized_" + userId + "@example.com");
        user.setMobileNumber(null);
        user.setFirstName("Anonymized");
        user.setLastName("User");
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean exportUserData(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Convert user data to a file format (e.g., JSON or CSV)
        UserDataExporter.export(user);
        return true;
    }

//    @Override
//    public List<UserProfileResponse> getTopUsersByActivity(int limit) {
//        List<UserEntity> users = userRepository.findTopUsersByActivity(limit);
//        return users.stream()
//                .map(UserMapper::toUserProfileResponse)
//                .collect(Collectors.toList());
//    }

    @Override
    public int getUserCountByStatus(String status) {
        return userRepository.countByAccountStatus(status);
    }
}
