package com.blissom.adminservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RoleEntity {

    @Id
    private String roleId;

    private String name;

    private String description;



    public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

