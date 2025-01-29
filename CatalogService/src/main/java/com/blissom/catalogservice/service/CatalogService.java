package com.blissom.catalogservice.service;

import java.util.List;

import com.blissom.catalogservice.dto.BulkPriceUpdateRequest;
import com.blissom.catalogservice.dto.CategoryAnalyticsResponse;
import com.blissom.catalogservice.dto.CategoryRequest;
import com.blissom.catalogservice.dto.CategoryResponse;
import com.blissom.catalogservice.dto.FilterRequest;
import com.blissom.catalogservice.dto.MediaRequest;
import com.blissom.catalogservice.dto.ServiceRequest;
import com.blissom.catalogservice.dto.ServiceResponse;
import com.blissom.catalogservice.dto.SubCategoryRequest;
import com.blissom.catalogservice.dto.SubCategoryResponse;

public interface CatalogService {

    // Service Management
    ServiceResponse createService(ServiceRequest request);
    ServiceResponse updateService(String serviceId, ServiceRequest request);
    boolean deleteService(String serviceId); // Soft delete
    ServiceResponse getServiceById(String serviceId);
    List<ServiceResponse> searchServices(String keyword); // Search services by name or description
    List<ServiceResponse> filterServices(FilterRequest filterRequest); // Filter services by category, price, duration, etc.

    // Category Management
    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse updateCategory(String categoryId, CategoryRequest request);
    boolean deleteCategory(String categoryId); // Soft delete
    CategoryResponse getCategoryById(String categoryId);
    List<CategoryResponse> getAllCategories();

    // Subcategory Management
    SubCategoryResponse createSubCategory(SubCategoryRequest request);
    SubCategoryResponse updateSubCategory(String subCategoryId, SubCategoryRequest request);
    boolean deleteSubCategory(String subCategoryId); // Soft delete
    SubCategoryResponse getSubCategoryById(String subCategoryId);
    List<SubCategoryResponse> getSubCategoriesByCategoryId(String categoryId);

    // Popular and Featured Services
    List<ServiceResponse> getPopularServices(int limit);
    List<ServiceResponse> getFeaturedServices();

    // Analytics and Reporting
    int getServiceCountByCategory(String categoryId);
    List<CategoryAnalyticsResponse> getCategoryAnalytics();

    // Bulk Operations
    boolean bulkUpdateServicePrices(BulkPriceUpdateRequest request);
    boolean bulkActivateServices(List<String> serviceIds);
    boolean bulkDeactivateServices(List<String> serviceIds);

    // Tags and Recommendations
    List<ServiceResponse> getServicesByTags(List<String> tags);
   // List<ServiceResponse> getRecommendedServices(String userId);

    // Media Management
    boolean addMediaToService(String serviceId, MediaRequest mediaRequest);
    boolean removeMediaFromService(String serviceId, String mediaId);

    // Status Management
    boolean activateService(String serviceId);
    boolean deactivateService(String serviceId);
}
