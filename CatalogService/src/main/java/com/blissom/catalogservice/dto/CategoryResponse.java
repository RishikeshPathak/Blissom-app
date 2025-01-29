package com.blissom.catalogservice.dto;

import java.util.List;

public class CategoryResponse {
    private String id;
    private String name;
    private boolean active;
    private List<SubCategoryResponse> subCategories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<SubCategoryResponse> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategoryResponse> subCategories) {
        this.subCategories = subCategories;
    }
}
