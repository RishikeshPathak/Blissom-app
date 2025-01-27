package com.blissom.userservice.dto;

public class PreferencesResponse {
	
    private String preferencesId;
    private String userId;
    private String theme;
    private String language;
    private boolean notificationsEnabled;
    
	public String getPreferencesId() {
		return preferencesId;
	}
	public void setPreferencesId(String preferencesId) {
		this.preferencesId = preferencesId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public boolean isNotificationsEnabled() {
		return notificationsEnabled;
	}
	public void setNotificationsEnabled(boolean notificationsEnabled) {
		this.notificationsEnabled = notificationsEnabled;
	}

}

