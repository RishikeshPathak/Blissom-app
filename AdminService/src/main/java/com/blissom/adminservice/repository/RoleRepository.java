package com.blissom.adminservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blissom.adminservice.model.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, String> {

    RoleEntity save(RoleEntity roleEntity);

    Optional<RoleEntity> findById(String id);

    void delete(RoleEntity roleEntity);

    List<RoleEntity> findAll();

    @Query("SELECT r FROM RoleEntity r WHERE r.name = ?1")
    Optional<RoleEntity> findByName(String name);
}

