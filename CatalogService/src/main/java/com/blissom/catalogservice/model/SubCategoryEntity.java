package com.blissom.catalogservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SubCategoryEntity {

    @Id
    private String subCategoryId;

    private String subCategoryName;

    private boolean subCategoryActive;

    private String categoryId;

        
public String getSubCategoryId() {
    return subCategoryId;
}

public void setSubCategoryId(String subCategoryId) {
    this.subCategoryId = subCategoryId;
}

public String getSubCategoryName() {
    return subCategoryName;
}

public void setSubCategoryName(String subCategoryName) {
    this.subCategoryName = subCategoryName;
}

public boolean isSubCategoryActive() {
    return subCategoryActive;
}

public void setSubCategoryActive(boolean subCategoryActive) {
    this.subCategoryActive = subCategoryActive;
}

public String getCategoryId() {
    return categoryId;
}

public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
}

    

}



