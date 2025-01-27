package com.blissom.adminservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.blissom.adminservice.dto.AdminResponse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class AdminEntity {

    @Id
    private String adminId;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean active;
    private boolean passwordResetRequired;
    private LocalDateTime createdAt;
    private LocalDate lastLogin;
    private String totalActions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
    private List<AdminRoleEntity> roles;



    public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public void setRoles(List<AdminRoleEntity> roles) {
		this.roles = roles;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPasswordResetRequired() {
        return passwordResetRequired;
    }

    public void setPasswordResetRequired(boolean passwordResetRequired) {
        this.passwordResetRequired = passwordResetRequired;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Transient
    public List<AdminResponse> getRoles() {
        return roles.stream()
                .map(role -> new AdminResponse(role.getRole().getRoleId(), role.getRole().getName()))
                .collect(Collectors.toList());
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


}

