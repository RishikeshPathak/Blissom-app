package com.blissom.catalogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blissom.catalogservice.dto.CategoryAnalyticsResponse;
import com.blissom.catalogservice.model.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {

    @Query("SELECT c FROM CategoryEntity c WHERE c.categoryActive = true")
    List<CategoryEntity> getActiveCategories();

    @Query("SELECT c FROM CategoryEntity c WHERE c.categoryId = :categoryId")    
    CategoryEntity getCategoryById(String categoryId);

    @Query(value = "SELECT c.category_name, COUNT(s.service_id) " +
    "FROM service s " +
    "JOIN category c ON s.category_id = c.category_id " +
    "GROUP BY c.category_name", nativeQuery = true)
List<CategoryAnalyticsResponse> getCategoryAnalytics();

}

