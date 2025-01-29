package com.blissom.catalogservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blissom.catalogservice.dto.FilterRequest;
import com.blissom.catalogservice.model.ServiceEntity;

import jakarta.transaction.Transactional;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, String> {

    @Query("SELECT s FROM ServiceEntity s WHERE s.serviceName LIKE %:keyword% OR s.serviceDescription LIKE %:keyword%")
    List<ServiceEntity> searchByKeyword(@Param("keyword") String keyword);

    @Query("SELECT s FROM ServiceEntity s WHERE (:#{#filterRequest.categoryId} IS NULL OR s.category.id = :#{#filterRequest.categoryId}) AND (:#{#filterRequest.subCategoryId} IS NULL OR s.subCategory.id = :#{#filterRequest.subCategoryId}) AND (:#{#filterRequest.priceStart} IS NULL OR s.price >= :#{#filterRequest.priceStart}) AND (:#{#filterRequest.priceEnd} IS NULL OR s.price <= :#{#filterRequest.priceEnd}) AND (:#{#filterRequest.tags} IS NULL OR s.tags IN (:#{#filterRequest.tags})) AND (:#{#filterRequest.active} IS NULL OR s.active = :#{#filterRequest.active})")
    List<ServiceEntity> filterServices(FilterRequest filterRequest);

    @Query("SELECT s FROM ServiceEntity s ORDER BY s.serviceName ASC")
    List<ServiceEntity> findPopularServices(int limit);

    @Query("SELECT s FROM ServiceEntity s WHERE s.featured = true")
    List<ServiceEntity> findFeaturedServices();

    @Query("SELECT COUNT(s) FROM ServiceEntity s WHERE s.category.id = :#{#categoryId}")
    int countByCategoryId(String categoryId);

    @Query("UPDATE ServiceEntity s SET s.price = s.price * (1 + :percentageChange / 100) WHERE s.price IS NOT NULL")
    @Modifying
    @Transactional
    boolean bulkUpdateServicePrices(@Param("percentageChange") double percentageChange);

    @Query("UPDATE ServiceEntity s SET s.active = :active WHERE s.serviceId IN (:serviceIds)")
    @Modifying
    @Transactional
    boolean bulkUpdateServiceStatus(@Param("serviceIds") List<String> serviceIds, @Param("active") boolean b);

    @Query("SELECT s FROM ServiceEntity s WHERE s.tags IN (:tags)")
    List<ServiceEntity> findByTagsIn(List<String> tags);

    
 
}


