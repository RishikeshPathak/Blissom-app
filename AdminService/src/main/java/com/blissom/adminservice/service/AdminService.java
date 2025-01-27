package com.blissom.adminservice.service;

import java.util.List;

import com.blissom.adminservice.dto.AdminActionLogRequest;
import com.blissom.adminservice.dto.AdminAnalyticsResponse;
import com.blissom.adminservice.dto.AdminDashboardResponse;
import com.blissom.adminservice.dto.AdminRequest;
import com.blissom.adminservice.dto.AdminResponse;
import com.blissom.adminservice.dto.AdminUpdateRequest;
import com.blissom.adminservice.dto.AuditLogResponse;
import com.blissom.adminservice.dto.NotificationRequest;
import com.blissom.adminservice.dto.PasswordResetRequest;
import com.blissom.adminservice.dto.RoleRequest;
import com.blissom.adminservice.dto.RoleResponse;
import com.blissom.adminservice.dto.RoleUpdateRequest;
import com.blissom.adminservice.dto.SecurityIncidentRequest;
import com.blissom.adminservice.dto.SecurityIncidentResponse;
import com.blissom.adminservice.dto.UserResponse;

public interface AdminService {

    // Admin Account Management
    AdminResponse createAdmin(AdminRequest request);
    AdminResponse updateAdmin(String adminId, AdminUpdateRequest request);
    boolean deactivateAdmin(String adminId);
    boolean activateAdmin(String adminId);
    AdminResponse getAdminById(String adminId);
    List<AdminResponse> getAllAdmins();

    // Role and Permission Management
    RoleResponse createRole(RoleRequest request);
    RoleResponse updateRole(String roleId, RoleUpdateRequest request);
    boolean deleteRole(String roleId);
    List<RoleResponse> getAllRoles();
    boolean assignRoleToAdmin(String adminId, String roleId);
    List<RoleResponse> getRolesByAdminId(String adminId);

    // Audit Logs
    List<AuditLogResponse> getAuditLogsByAdminId(String adminId);
    List<AuditLogResponse> getAuditLogsByDateRange(String startDate, String endDate);
    boolean logAdminAction(AdminActionLogRequest request);

    // User Management
    boolean deactivateUser(String userId);
    boolean activateUser(String userId);
    List<UserResponse> getAllUsers();
    List<UserResponse> searchUsers(String query);
    boolean resetUserPassword(String userId, PasswordResetRequest request);

    // Analytics and Reporting
    AdminDashboardResponse getDashboardMetrics();
    List<AdminAnalyticsResponse> getAdminActivityAnalytics(String startDate, String endDate);
    int getTotalActiveAdmins();
    int getTotalDeactivatedAdmins();

    // Notifications
    boolean sendNotificationToAllAdmins(NotificationRequest request);
    boolean sendNotificationToAdmin(String adminId, NotificationRequest request);

    // Advanced Features
    boolean escalateIssue(String issueId, String escalationReason);
    boolean resolveIssue(String issueId, String resolutionDetails);

    // System-Level Operations
    boolean initiateSystemBackup();
    boolean restoreSystemBackup(String backupId);
    boolean monitorSystemHealth();

    // Bulk Operations
    boolean bulkDeactivateAdmins(List<String> adminIds);
    boolean bulkActivateAdmins(List<String> adminIds);

    // Security and Compliance
    boolean forcePasswordReset(String adminId);
    boolean logSecurityIncident(SecurityIncidentRequest request);
    List<SecurityIncidentResponse> getSecurityIncidents(String startDate, String endDate);
}
