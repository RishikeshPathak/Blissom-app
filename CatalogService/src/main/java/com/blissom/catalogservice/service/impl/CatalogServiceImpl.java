package com.blissom.catalogservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.blissom.catalogservice.mapper.CategoryMapper;
import com.blissom.catalogservice.mapper.MediaMapper;
import com.blissom.catalogservice.mapper.ServiceMapper;
import com.blissom.catalogservice.mapper.SubCategoryMapper;
import com.blissom.catalogservice.model.CategoryEntity;
import com.blissom.catalogservice.model.MediaEntity;
import com.blissom.catalogservice.model.ServiceEntity;
import com.blissom.catalogservice.model.SubCategoryEntity;
import com.blissom.catalogservice.repository.CategoryRepository;
import com.blissom.catalogservice.repository.MediaRepository;
import com.blissom.catalogservice.repository.ServiceRepository;
import com.blissom.catalogservice.repository.SubCategoryRepository;
import com.blissom.catalogservice.service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private ServiceMapper serviceMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @Autowired
    private MediaMapper mediaMapper;

    // --- Service Management ---

    @Override
    public ServiceResponse createService(ServiceRequest request) {
        ServiceEntity serviceEntity = serviceMapper.toEntity(request);
        serviceRepository.save(serviceEntity);
        return serviceMapper.toResponse(serviceEntity);
    }

    @Override
    public ServiceResponse updateService(String serviceId, ServiceRequest request) {
        ServiceEntity serviceEntity = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new IllegalArgumentException("Service not found"));

        serviceMapper.updateEntityFromRequest(request, serviceEntity);
        serviceRepository.save(serviceEntity);
        return serviceMapper.toResponse(serviceEntity);
    }

    @Override
    public boolean deleteService(String serviceId) {
        ServiceEntity serviceEntity = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new IllegalArgumentException("Service not found"));

        serviceEntity.setActive(false); // Soft delete
        serviceRepository.save(serviceEntity);
        return true;
    }

    @Override
    public ServiceResponse getServiceById(String serviceId) {
        ServiceEntity serviceEntity = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new IllegalArgumentException("Service not found"));

        return serviceMapper.toResponse(serviceEntity);
    }

    @Override
    public List<ServiceResponse> searchServices(String keyword) {
        List<ServiceEntity> services = serviceRepository.searchByKeyword(keyword);
        return services.stream().map(serviceMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<ServiceResponse> filterServices(FilterRequest filterRequest) {
        List<ServiceEntity> services = serviceRepository.filterServices(filterRequest);
        return services.stream().map(serviceMapper::toResponse).collect(Collectors.toList());
    }

    // --- Category Management ---

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(request);
        categoryRepository.save(categoryEntity);
        return categoryMapper.toResponse(categoryEntity);
    }

    @Override
    public CategoryResponse updateCategory(String categoryId, CategoryRequest request) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        categoryMapper.updateEntityFromRequest(request, categoryEntity);
        categoryRepository.save(categoryEntity);
        return categoryMapper.toResponse(categoryEntity);
    }

    @Override
    public boolean deleteCategory(String categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        categoryEntity.setCategoryActive(false); // Soft delete
        categoryRepository.save(categoryEntity);
        return true;
    }

    @Override
    public CategoryResponse getCategoryById(String categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        return categoryMapper.toResponse(categoryEntity);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toResponse).collect(Collectors.toList());
    }

    // --- Subcategory Management ---

    @Override
    public SubCategoryResponse createSubCategory(SubCategoryRequest request) {
        SubCategoryEntity subCategoryEntity = subCategoryMapper.toEntity(request);
        subCategoryRepository.save(subCategoryEntity);
        return subCategoryMapper.toResponse(subCategoryEntity);
    }

    @Override
    public SubCategoryResponse updateSubCategory(String subCategoryId, SubCategoryRequest request) {
        SubCategoryEntity subCategoryEntity = subCategoryRepository.findById(subCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Subcategory not found"));

        subCategoryMapper.updateEntityFromRequest(request, subCategoryEntity);
        subCategoryRepository.save(subCategoryEntity);
        return subCategoryMapper.toResponse(subCategoryEntity);
    }

    @Override
    public boolean deleteSubCategory(String subCategoryId) {
        SubCategoryEntity subCategoryEntity = subCategoryRepository.findById(subCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Subcategory not found"));

        subCategoryEntity.setSubCategoryActive(false); // Soft delete
        subCategoryRepository.save(subCategoryEntity);
        return true;
    }

    @Override
    public SubCategoryResponse getSubCategoryById(String subCategoryId) {
        SubCategoryEntity subCategoryEntity = subCategoryRepository.findById(subCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Subcategory not found"));

        return subCategoryMapper.toResponse(subCategoryEntity);
    }

    @Override
    public List<SubCategoryResponse> getSubCategoriesByCategoryId(String categoryId) {
        List<SubCategoryEntity> subCategories = subCategoryRepository.findByCategoryId(categoryId);
        return subCategories.stream().map(subCategoryMapper::toResponse).collect(Collectors.toList());
    }

    // --- Popular and Featured Services ---

    @Override
    public List<ServiceResponse> getPopularServices(int limit) {
        List<ServiceEntity> services = serviceRepository.findPopularServices(limit);
        return services.stream().map(serviceMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<ServiceResponse> getFeaturedServices() {
        List<ServiceEntity> services = serviceRepository.findFeaturedServices();
        return services.stream().map(serviceMapper::toResponse).collect(Collectors.toList());
    }

    // --- Analytics and Reporting ---

    @Override
    public int getServiceCountByCategory(String categoryId) {
        return serviceRepository.countByCategoryId(categoryId);
    }

    @Override
    public List<CategoryAnalyticsResponse> getCategoryAnalytics() {
        return categoryRepository.getCategoryAnalytics();
    }

    // --- Bulk Operations ---

    @Override
    public boolean bulkUpdateServicePrices(BulkPriceUpdateRequest request) {
        return serviceRepository.bulkUpdateServicePrices(request.getPercentageChange());
    }

    @Override
    public boolean bulkActivateServices(List<String> serviceIds) {
        return serviceRepository.bulkUpdateServiceStatus(serviceIds, true);
    }

    @Override
    public boolean bulkDeactivateServices(List<String> serviceIds) {
        return serviceRepository.bulkUpdateServiceStatus(serviceIds, false);
    }

    // --- Tags and Recommendations ---

    @Override
    public List<ServiceResponse> getServicesByTags(List<String> tags) {
        List<ServiceEntity> services = serviceRepository.findByTagsIn(tags);
        return services.stream().map(serviceMapper::toResponse).collect(Collectors.toList());
    }

	/*
	 * @Override public List<ServiceResponse> getRecommendedServices(String userId)
	 * { List<ServiceEntity> services =
	 * serviceRepository.findRecommendedServices(userId); return
	 * services.stream().map(serviceMapper::toResponse).collect(Collectors.toList())
	 * ; }
	 */

    // --- Media Management ---

    @Override
    public boolean addMediaToService(String serviceId, MediaRequest mediaRequest) {
        ServiceEntity serviceEntity = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new IllegalArgumentException("Service not found"));

        MediaEntity media = mediaMapper.toEntity(mediaRequest);
        media.setService(serviceEntity);
        mediaRepository.save(media);
        return true;
    }

    @Override
    public boolean removeMediaFromService(String serviceId, String mediaId) {
        MediaEntity media = mediaRepository.findById(mediaId)
                .orElseThrow(() -> new IllegalArgumentException("Media not found"));

        mediaRepository.delete(media);
        return true;
    }

    // --- Status Management ---

    @Override
    public boolean activateService(String serviceId) {
        return updateServiceStatus(serviceId, true);
    }

    @Override
    public boolean deactivateService(String serviceId) {
        return updateServiceStatus(serviceId, false);
    }

    private boolean updateServiceStatus(String serviceId, boolean active) {
        ServiceEntity serviceEntity = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new IllegalArgumentException("Service not found"));

        serviceEntity.setActive(active);
        serviceRepository.save(serviceEntity);
        return true;
    }
}
