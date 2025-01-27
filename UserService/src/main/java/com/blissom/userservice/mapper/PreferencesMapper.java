package com.blissom.userservice.mapper;

import com.blissom.userservice.dto.PreferencesResponse;
import com.blissom.userservice.model.PreferencesEntity;

public class PreferencesMapper {

    public static PreferencesResponse toPreferencesResponse(PreferencesEntity preferences) {
        PreferencesResponse response = new PreferencesResponse();
        response.setPreferencesId(preferences.getPreferencesId());
        response.setUserId(preferences.getUserId());
        response.setTheme(preferences.getTheme());
        response.setLanguage(preferences.getLanguage());
        response.setNotificationsEnabled(preferences.isNotificationsEnabled());
        return response;
    }

}
