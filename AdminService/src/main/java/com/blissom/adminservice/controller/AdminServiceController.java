package com.blissom.adminservice.controller;


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
import com.blissom.adminservice.service.AdminService;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminServiceController {

    @Autowired
    private AdminService adminService;

    // --- Admin Account Management ---

    @PostMapping
    public ResponseEntity<AdminResponse> createAdmin(@RequestBody AdminRequest request) {
        AdminResponse response = adminService.createAdmin(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<AdminResponse> updateAdmin(@PathVariable String adminId,
                                                     @RequestBody AdminUpdateRequest request) {
        AdminResponse response = adminService.updateAdmin(adminId, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{adminId}/deactivate")
    public ResponseEntity<Boolean> deactivateAdmin(@PathVariable String adminId) {
        boolean result = adminService.deactivateAdmin(adminId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{adminId}/activate")
    public ResponseEntity<Boolean> activateAdmin(@PathVariable String adminId) {
        boolean result = adminService.activateAdmin(adminId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<AdminResponse> getAdminById(@PathVariable String adminId) {
        AdminResponse response = adminService.getAdminById(adminId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AdminResponse>> getAllAdmins() {
        List<AdminResponse> response = adminService.getAllAdmins();
        return ResponseEntity.ok(response);
    }

    // --- Role and Permission Management ---

    @PostMapping("/roles")
    public ResponseEntity<RoleResponse> createRole(@RequestBody RoleRequest request) {
        RoleResponse response = adminService.createRole(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/roles/{roleId}")
    public ResponseEntity<RoleResponse> updateRole(@PathVariable String roleId,
                                                   @RequestBody RoleUpdateRequest request) {
        RoleResponse response = adminService.updateRole(roleId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/roles/{roleId}")
    public ResponseEntity<Boolean> deleteRole(@PathVariable String roleId) {
        boolean result = adminService.deleteRole(roleId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleResponse>> getAllRoles() {
        List<RoleResponse> response = adminService.getAllRoles();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{adminId}/roles/{roleId}")
    public ResponseEntity<Boolean> assignRoleToAdmin(@PathVariable String adminId, @PathVariable String roleId) {
        boolean result = adminService.assignRoleToAdmin(adminId, roleId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{adminId}/roles")
    public ResponseEntity<List<RoleResponse>> getRolesByAdminId(@PathVariable String adminId) {
        List<RoleResponse> response = adminService.getRolesByAdminId(adminId);
        return ResponseEntity.ok(response);
    }

    // --- Audit Logs ---

    @GetMapping("/{adminId}/audit-logs")
    public ResponseEntity<List<AuditLogResponse>> getAuditLogsByAdminId(@PathVariable String adminId) {
        List<AuditLogResponse> response = adminService.getAuditLogsByAdminId(adminId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/audit-logs")
    public ResponseEntity<List<AuditLogResponse>> getAuditLogsByDateRange(@RequestParam String startDate,
                                                                          @RequestParam String endDate) {
        List<AuditLogResponse> response = adminService.getAuditLogsByDateRange(startDate, endDate);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/audit-logs")
    public ResponseEntity<Boolean> logAdminAction(@RequestBody AdminActionLogRequest request) {
        boolean result = adminService.logAdminAction(request);
        return ResponseEntity.ok(result);
    }

    // --- User Management ---

    @PostMapping("/users/{userId}/deactivate")
    public ResponseEntity<Boolean> deactivateUser(@PathVariable String userId) {
        boolean result = adminService.deactivateUser(userId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/users/{userId}/activate")
    public ResponseEntity<Boolean> activateUser(@PathVariable String userId) {
        boolean result = adminService.activateUser(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> response = adminService.getAllUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/search")
    public ResponseEntity<List<UserResponse>> searchUsers(@RequestParam String query) {
        List<UserResponse> response = adminService.searchUsers(query);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/users/{userId}/reset-password")
    public ResponseEntity<Boolean> resetUserPassword(@PathVariable String userId,
                                                     @RequestBody PasswordResetRequest request) {
        boolean result = adminService.resetUserPassword(userId, request);
        return ResponseEntity.ok(result);
    }

    // --- Analytics and Reporting ---

    @GetMapping("/dashboard")
    public ResponseEntity<AdminDashboardResponse> getDashboardMetrics() {
        AdminDashboardResponse response = adminService.getDashboardMetrics();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/analytics")
    public ResponseEntity<List<AdminAnalyticsResponse>> getAdminActivityAnalytics(@RequestParam String startDate,
                                                                                  @RequestParam String endDate) {
        List<AdminAnalyticsResponse> response = adminService.getAdminActivityAnalytics(startDate, endDate);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/active-admins-count")
    public ResponseEntity<Integer> getTotalActiveAdmins() {
        int count = adminService.getTotalActiveAdmins();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/deactivated-admins-count")
    public ResponseEntity<Integer> getTotalDeactivatedAdmins() {
        int count = adminService.getTotalDeactivatedAdmins();
        return ResponseEntity.ok(count);
    }

    // --- Notifications ---

    @PostMapping("/notifications")
    public ResponseEntity<Boolean> sendNotificationToAllAdmins(@RequestBody NotificationRequest request) {
        boolean result = adminService.sendNotificationToAllAdmins(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{adminId}/notifications")
    public ResponseEntity<Boolean> sendNotificationToAdmin(@PathVariable String adminId,
                                                            @RequestBody NotificationRequest request) {
        boolean result = adminService.sendNotificationToAdmin(adminId, request);
        return ResponseEntity.ok(result);
    }

    // --- Advanced Features ---

    @PostMapping("/issues/{issueId}/escalate")
    public ResponseEntity<Boolean> escalateIssue(@PathVariable String issueId,
                                                 @RequestParam String escalationReason) {
        boolean result = adminService.escalateIssue(issueId, escalationReason);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/issues/{issueId}/resolve")
    public ResponseEntity<Boolean> resolveIssue(@PathVariable String issueId,
                                                @RequestParam String resolutionDetails) {
        boolean result = adminService.resolveIssue(issueId, resolutionDetails);
        return ResponseEntity.ok(result);
    }

    // --- System-Level Operations ---

    @PostMapping("/system/backup")
    public ResponseEntity<Boolean> initiateSystemBackup() {
        boolean result = adminService.initiateSystemBackup();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/system/restore")
    public ResponseEntity<Boolean> restoreSystemBackup(@RequestParam String backupId) {
        boolean result = adminService.restoreSystemBackup(backupId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/system/health")
    public ResponseEntity<Boolean> monitorSystemHealth() {
        boolean result = adminService.monitorSystemHealth();
        return ResponseEntity.ok(result);
    }

    // --- Bulk Operations ---

    @PostMapping("/bulk/deactivate")
    public ResponseEntity<Boolean> bulkDeactivateAdmins(@RequestBody List<String> adminIds) {
        boolean result = adminService.bulkDeactivateAdmins(adminIds);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/bulk/activate")
    public ResponseEntity<Boolean> bulkActivateAdmins(@RequestBody List<String> adminIds) {
        boolean result = adminService.bulkActivateAdmins(adminIds);
        return ResponseEntity.ok(result);
    }

    // --- Security and Compliance ---

    @PostMapping("/{adminId}/force-password-reset")
    public ResponseEntity<Boolean> forcePasswordReset(@PathVariable String adminId) {
        boolean result = adminService.forcePasswordReset(adminId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/security-incidents")
    public ResponseEntity<Boolean> logSecurityIncident(@RequestBody SecurityIncidentRequest request) {
        boolean result = adminService.logSecurityIncident(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/security-incidents")
    public ResponseEntity<List<SecurityIncidentResponse>> getSecurityIncidents(@RequestParam String startDate,
                                                                               @RequestParam String endDate) {
        List<SecurityIncidentResponse> response = adminService.getSecurityIncidents(startDate, endDate);
        return ResponseEntity.ok(response);
    }
}

