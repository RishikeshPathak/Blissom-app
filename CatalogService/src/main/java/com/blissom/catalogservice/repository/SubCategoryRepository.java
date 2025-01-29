package com.blissom.catalogservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blissom.catalogservice.model.SubCategoryEntity;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, String> {

	List<SubCategoryEntity> findByCategoryId(String categoryId);

    

}

