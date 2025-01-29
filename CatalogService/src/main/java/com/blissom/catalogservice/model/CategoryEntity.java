package com.blissom.catalogservice.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CategoryEntity {

    @Id
    private String categoryId;
    private String categoryName;
    private boolean categoryActive;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isCategoryActive() {
        return categoryActive;
    }

    public void setCategoryActive(boolean categoryActive) {
        this.categoryActive = categoryActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryEntity)) return false;
        CategoryEntity that = (CategoryEntity) o;
        return categoryActive == that.categoryActive &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, categoryActive);
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryActive=" + categoryActive +
                '}';
    }
}



