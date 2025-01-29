package com.blissom.catalogservice.controller;

import com.blissom.catalogservice.dto.*;
import com.blissom.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // Service Management
    @PostMapping("/services")
    public ResponseEntity<ServiceResponse> createService(@RequestBody ServiceRequest request) {
        return ResponseEntity.ok(catalogService.createService(request));
    }

    @PutMapping("/services/{serviceId}")
    public ResponseEntity<ServiceResponse> updateService(@PathVariable String serviceId, @RequestBody ServiceRequest request) {
        return ResponseEntity.ok(catalogService.updateService(serviceId, request));
    }

    @DeleteMapping("/services/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable String serviceId) {
        catalogService.deleteService(serviceId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/services/{serviceId}")
    public ResponseEntity<ServiceResponse> getServiceById(@PathVariable String serviceId) {
        return ResponseEntity.ok(catalogService.getServiceById(serviceId));
    }

    @GetMapping("/services/search")
    public ResponseEntity<List<ServiceResponse>> searchServices(@RequestParam String keyword) {
        return ResponseEntity.ok(catalogService.searchServices(keyword));
    }

    @PostMapping("/services/filter")
    public ResponseEntity<List<ServiceResponse>> filterServices(@RequestBody FilterRequest filterRequest) {
        return ResponseEntity.ok(catalogService.filterServices(filterRequest));
    }

    // Category Management
    @PostMapping("/categories")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(catalogService.createCategory(request));
    }

    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable String categoryId, @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(catalogService.updateCategory(categoryId, request));
    }

    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String categoryId) {
        catalogService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable String categoryId) {
        return ResponseEntity.ok(catalogService.getCategoryById(categoryId));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(catalogService.getAllCategories());
    }

    // Subcategory Management
    @PostMapping("/subcategories")
    public ResponseEntity<SubCategoryResponse> createSubCategory(@RequestBody SubCategoryRequest request) {
        return ResponseEntity.ok(catalogService.createSubCategory(request));
    }

    @PutMapping("/subcategories/{subCategoryId}")
    public ResponseEntity<SubCategoryResponse> updateSubCategory(@PathVariable String subCategoryId, @RequestBody SubCategoryRequest request) {
        return ResponseEntity.ok(catalogService.updateSubCategory(subCategoryId, request));
    }

    @DeleteMapping("/subcategories/{subCategoryId}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable String subCategoryId) {
        catalogService.deleteSubCategory(subCategoryId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/subcategories/{subCategoryId}")
    public ResponseEntity<SubCategoryResponse> getSubCategoryById(@PathVariable String subCategoryId) {
        return ResponseEntity.ok(catalogService.getSubCategoryById(subCategoryId));
    }

    @GetMapping("/subcategories/category/{categoryId}")
    public ResponseEntity<List<SubCategoryResponse>> getSubCategoriesByCategoryId(@PathVariable String categoryId) {
        return ResponseEntity.ok(catalogService.getSubCategoriesByCategoryId(categoryId));
    }

    // Popular and Featured Services
    @GetMapping("/services/popular")
    public ResponseEntity<List<ServiceResponse>> getPopularServices(@RequestParam int limit) {
        return ResponseEntity.ok(catalogService.getPopularServices(limit));
    }

    @GetMapping("/services/featured")
    public ResponseEntity<List<ServiceResponse>> getFeaturedServices() {
        return ResponseEntity.ok(catalogService.getFeaturedServices());
    }

    // Analytics and Reporting
    @GetMapping("/analytics/category/{categoryId}")
    public ResponseEntity<Integer> getServiceCountByCategory(@PathVariable String categoryId) {
        return ResponseEntity.ok(catalogService.getServiceCountByCategory(categoryId));
    }

    @GetMapping("/analytics")
    public ResponseEntity<List<CategoryAnalyticsResponse>> getCategoryAnalytics() {
        return ResponseEntity.ok(catalogService.getCategoryAnalytics());
    }

    // Bulk Operations
    @PostMapping("/services/bulk/price-update")
    public ResponseEntity<Boolean> bulkUpdateServicePrices(@RequestBody BulkPriceUpdateRequest request) {
        return ResponseEntity.ok(catalogService.bulkUpdateServicePrices(request));
    }

    @PostMapping("/services/bulk/activate")
    public ResponseEntity<Boolean> bulkActivateServices(@RequestBody List<String> serviceIds) {
        return ResponseEntity.ok(catalogService.bulkActivateServices(serviceIds));
    }

    @PostMapping("/services/bulk/deactivate")
    public ResponseEntity<Boolean> bulkDeactivateServices(@RequestBody List<String> serviceIds) {
        return ResponseEntity.ok(catalogService.bulkDeactivateServices(serviceIds));
    }

    // Tags and Recommendations
    @PostMapping("/services/tags")
    public ResponseEntity<List<ServiceResponse>> getServicesByTags(@RequestBody List<String> tags) {
        return ResponseEntity.ok(catalogService.getServicesByTags(tags));
    }

//    @GetMapping("/services/recommended/{userId}")
//    public ResponseEntity<List<ServiceResponse>> getRecommendedServices(@PathVariable String userId) {
//        return ResponseEntity.ok(catalogService.getRecommendedServices(userId));
//    }

    // Media Management
    @PostMapping("/services/{serviceId}/media")
    public ResponseEntity<Boolean> addMediaToService(@PathVariable String serviceId, @RequestBody MediaRequest mediaRequest) {
        return ResponseEntity.ok(catalogService.addMediaToService(serviceId, mediaRequest));
    }

    @DeleteMapping("/services/{serviceId}/media/{mediaId}")
    public ResponseEntity<Boolean> removeMediaFromService(@PathVariable String serviceId, @PathVariable String mediaId) {
        return ResponseEntity.ok(catalogService.removeMediaFromService(serviceId, mediaId));
    }

    // Status Management
    @PostMapping("/services/{serviceId}/activate")
    public ResponseEntity<Boolean> activateService(@PathVariable String serviceId) {
        return ResponseEntity.ok(catalogService.activateService(serviceId));
    }

    @PostMapping("/services/{serviceId}/deactivate")
    public ResponseEntity<Boolean> deactivateService(@PathVariable String serviceId) {
        return ResponseEntity.ok(catalogService.deactivateService(serviceId));
    }
}
