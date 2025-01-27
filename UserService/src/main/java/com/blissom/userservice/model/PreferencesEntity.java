package com.blissom.userservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_preferences")
public class PreferencesEntity {
    @Id
    @Column(name = "preferences_id", nullable = false)
    private String preferencesId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "theme", nullable = false)
    private String theme;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "notifications_enabled", nullable = false)
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

