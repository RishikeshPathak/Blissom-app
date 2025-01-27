package com.blissom.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blissom.userservice.model.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, String> {

    @Query("SELECT a FROM AddressEntity a WHERE a.userId = :userId")
    List<AddressEntity> findByUserId(@Param("userId") String userId);

}


