package com.blissom.adminservice.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.blissom.adminservice.mapper.AdminMapper;
import com.blissom.adminservice.mapper.AuditLogMapper;
import com.blissom.adminservice.mapper.RoleMapper;
import com.blissom.adminservice.mapper.SecurityIncidentMapper;
import com.blissom.adminservice.mapper.UserMapper;
import com.blissom.adminservice.model.AdminEntity;
import com.blissom.adminservice.model.AuditLogEntity;
import com.blissom.adminservice.model.RoleEntity;
import com.blissom.adminservice.model.SecurityIncidentEntity;
import com.blissom.adminservice.model.UserEntity;
import com.blissom.adminservice.repository.AdminRepository;
import com.blissom.adminservice.repository.AuditLogRepository;
import com.blissom.adminservice.repository.RoleRepository;
import com.blissom.adminservice.repository.SecurityIncidentRepository;
import com.blissom.adminservice.repository.UserRepository;
import com.blissom.adminservice.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityIncidentRepository securityIncidentRepository;

    @Autowired
    private AdminMapper adminMapper;    

    @Autowired
    private RoleMapper roleMapper;    

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuditLogMapper auditLogMapper;    

    @Autowired
    private SecurityIncidentMapper securityIncidentMapper;  

    // --- Admin Account Management ---

    @Override
    public AdminResponse createAdmin(AdminRequest request) {
        AdminEntity adminEntity = adminMapper.toEntity(request);
        adminEntity.setActive(true);
        adminEntity.setCreatedAt(LocalDateTime.now());
        adminRepository.save(adminEntity);
        return adminMapper.toResponse(adminEntity);
    }

    @Override
    public AdminResponse updateAdmin(String adminId, AdminUpdateRequest request) {
        AdminEntity adminEntity = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));

        adminMapper.updateEntityFromRequest(request, adminEntity);
        adminRepository.save(adminEntity);
        return adminMapper.toResponse(adminEntity);
    }

    @Override
    public boolean deactivateAdmin(String adminId) {
        AdminEntity adminEntity = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));

        adminEntity.setActive(false);
        adminRepository.save(adminEntity);
        return true;
    }

    @Override
    public boolean activateAdmin(String adminId) {
        AdminEntity adminEntity = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));

        adminEntity.setActive(true);
        adminRepository.save(adminEntity);
        return true;
    }

    @Override
    public AdminResponse getAdminById(String adminId) {
        AdminEntity adminEntity = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));

        return adminMapper.toResponse(adminEntity);
    }

    @Override
    public List<AdminResponse> getAllAdmins() {
        List<AdminEntity> admins = adminRepository.findAll();
        return admins.stream().map(adminMapper::toResponse).collect(Collectors.toList());
    }

    // --- Role and Permission Management ---

    @Override
    public RoleResponse createRole(RoleRequest request) {
        RoleEntity roleEntity = roleMapper.toEntity(request);
        roleRepository.save(roleEntity);
        return roleMapper.toResponse(roleEntity);
    }

    @Override
    public RoleResponse updateRole(String roleId, RoleUpdateRequest request) {
        RoleEntity roleEntity = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        roleMapper.updateEntityFromRequest(request, roleEntity);
        roleRepository.save(roleEntity);
        return roleMapper.toResponse(roleEntity);
    }

    @Override
    public boolean deleteRole(String roleId) {
        RoleEntity roleEntity = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        roleRepository.delete(roleEntity);
        return true;
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        List<RoleEntity> roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public boolean assignRoleToAdmin(String adminId, String roleId) {
        AdminEntity adminEntity = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));

        RoleEntity roleEntity = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        adminEntity.getRoles().add(roleMapper.toAdminEntityResponse(roleEntity));
        adminRepository.save(adminEntity);
        return true;
    }

    @Override
    public List<RoleResponse> getRolesByAdminId(String adminId) {
        AdminEntity adminEntity = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));
    
                return adminEntity.getRoles().stream()
        .map(roleMapper::toAdminEntityResponse)
        .collect(Collectors.toList());
    }

    // --- Audit Logs ---

    @Override
    public List<AuditLogResponse> getAuditLogsByAdminId(String adminId) {
        List<AuditLogEntity> logs = auditLogRepository.findByAdminId(adminId);
        return logs.stream().map(auditLogMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<AuditLogResponse> getAuditLogsByDateRange(String startDate, String endDate) {
        List<AuditLogEntity> logs = auditLogRepository.findByDateRange(startDate, endDate);
        return logs.stream().map(auditLogMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public boolean logAdminAction(AdminActionLogRequest request) {
        AuditLogEntity logEntity = auditLogMapper.toEntity(request);
        auditLogRepository.save(logEntity);
        return true;
    }

    // --- User Management ---

    @Override
    public boolean deactivateUser(String userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        userEntity.setActive(false);
        userRepository.save(userEntity);
        return true;
    }

    @Override
    public boolean activateUser(String userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        userEntity.setActive(true);
        userRepository.save(userEntity);
        return true;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(userMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<UserResponse> searchUsers(String query) {
        List<UserEntity> users = userRepository.searchByQuery(query);
        return users.stream().map(userMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public boolean resetUserPassword(String userId, PasswordResetRequest request) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        userEntity.setPassword(request.getNewPassword());
        userRepository.save(userEntity);
        return true;
    }

    // --- Analytics and Reporting ---

    @Override
    public AdminDashboardResponse getDashboardMetrics() {
        // Logic to aggregate dashboard metrics
        return new AdminDashboardResponse();
    }

    @Override
    public List<AdminAnalyticsResponse> getAdminActivityAnalytics(String startDate, String endDate) {
        List<AdminEntity> admins = adminRepository.findActivityAnalytics(startDate, endDate);
        return admins.stream().map(adminMapper::toAnalyticsResponse).collect(Collectors.toList());
    }

    @Override
    public int getTotalActiveAdmins() {
        return adminRepository.countByActive(true);
    }

    @Override
    public int getTotalDeactivatedAdmins() {
        return adminRepository.countByActive(false);
    }

    // --- Notifications ---

    @Override
    public boolean sendNotificationToAllAdmins(NotificationRequest request) {
        // Logic to send notifications to all admins
        return true;
    }

    @Override
    public boolean sendNotificationToAdmin(String adminId, NotificationRequest request) {
        // Logic to send notification to a specific admin
        return true;
    }

    // --- Advanced Features ---

    @Override
    public boolean escalateIssue(String issueId, String escalationReason) {
        // Logic to escalate issues
        return true;
    }

    @Override
    public boolean resolveIssue(String issueId, String resolutionDetails) {
        // Logic to resolve issues
        return true;
    }

    // --- System-Level Operations ---

    @Override
    public boolean initiateSystemBackup() {
        // Logic to initiate a system backup
        return true;
    }

    @Override
    public boolean restoreSystemBackup(String backupId) {
        // Logic to restore a system backup
        return true;
    }

    @Override
    public boolean monitorSystemHealth() {
        // Logic to monitor system health
        return true;
    }

    // --- Bulk Operations ---

    @Override
    public boolean bulkDeactivateAdmins(List<String> adminIds) {
        return adminRepository.bulkUpdateActiveStatus(adminIds, false);
    }

    @Override
    public boolean bulkActivateAdmins(List<String> adminIds) {
        return adminRepository.bulkUpdateActiveStatus(adminIds, true);
    }

    // --- Security and Compliance ---

    @Override
    public boolean forcePasswordReset(String adminId) {
        AdminEntity adminEntity = adminRepository.findById(adminId)
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));

        adminEntity.setPasswordResetRequired(true);
        adminRepository.save(adminEntity);
        return true;
    }

    @Override
    public boolean logSecurityIncident(SecurityIncidentRequest request) {
        SecurityIncidentEntity incidentEntity = securityIncidentMapper.toEntity(request);
        securityIncidentRepository.save(incidentEntity);
        return true;
    }

    @Override
    public List<SecurityIncidentResponse> getSecurityIncidents(String startDate, String endDate) {
        List<SecurityIncidentEntity> incidents = securityIncidentRepository.findByDateRange(startDate, endDate);
        return incidents.stream().map(securityIncidentMapper::toResponse).collect(Collectors.toList());
    }
}
