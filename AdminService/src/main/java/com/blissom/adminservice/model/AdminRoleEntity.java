package com.blissom.adminservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class AdminRoleEntity {

    @Id
    private String aminRoleId;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;



    public String getAminRoleId() {
		return aminRoleId;
	}

	public void setAminRoleId(String aminRoleId) {
		this.aminRoleId = aminRoleId;
	}

	public AdminEntity getAdmin() {
        return admin;
    }

    public void setAdmin(AdminEntity admin) {
        this.admin = admin;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}

