package com.blissom.userservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blissom.userservice.model.ActivityLogEntity;





@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLogEntity, String> {

    @Query("SELECT a FROM ActivityLogEntity a WHERE a.userId = :userId")
    List<ActivityLogEntity> findByUser_UserId(@Param("userId") String userId);

}
