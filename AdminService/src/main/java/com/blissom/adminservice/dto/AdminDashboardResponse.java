package com.blissom.adminservice.dto;

import java.util.List;

public class AdminDashboardResponse {
    private int totalActiveAdmins;
    private int totalDeactivatedAdmins;
    private List<String> recentActivities;
    private List<String> systemAlerts;

    public AdminDashboardResponse(int totalActiveAdmins, int totalDeactivatedAdmins, List<String> recentActivities, List<String> systemAlerts) {
        this.totalActiveAdmins = totalActiveAdmins;
        this.totalDeactivatedAdmins = totalDeactivatedAdmins;
        this.recentActivities = recentActivities;
        this.systemAlerts = systemAlerts;
    }

    public AdminDashboardResponse() {
       
    }

    public int getTotalActiveAdmins() {
        return totalActiveAdmins;
    }

    public void setTotalActiveAdmins(int totalActiveAdmins) {
        this.totalActiveAdmins = totalActiveAdmins;
    }

    public int getTotalDeactivatedAdmins() {
        return totalDeactivatedAdmins;
    }

    public void setTotalDeactivatedAdmins(int totalDeactivatedAdmins) {
        this.totalDeactivatedAdmins = totalDeactivatedAdmins;
    }

    public List<String> getRecentActivities() {
        return recentActivities;
    }

    public void setRecentActivities(List<String> recentActivities) {
        this.recentActivities = recentActivities;
    }

    public List<String> getSystemAlerts() {
        return systemAlerts;
    }

    public void setSystemAlerts(List<String> systemAlerts) {
        this.systemAlerts = systemAlerts;
    }
}

