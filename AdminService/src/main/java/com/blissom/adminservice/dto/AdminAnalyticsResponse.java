package com.blissom.adminservice.dto;

import java.time.LocalDate;

public class AdminAnalyticsResponse {

    private String adminId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate lastLogin;
    private String totalActions;
    private String totalLogs;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getTotalActions() {
        return totalActions;
    }

    public void setTotalActions(String totalActions) {
        this.totalActions = totalActions;
    }

    public String getTotalLogs() {
        return totalLogs;
    }

    public void setTotalLogs(String totalLogs) {
        this.totalLogs = totalLogs;
    }
}

