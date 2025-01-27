package com.blissom.adminservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blissom.adminservice.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findById(String userId);

    UserEntity save(UserEntity userEntity);

    List<UserEntity> findAll();

    default List<UserEntity> findByFirstNameContainingOrLastNameContainingOrEmailContaining(
            String query, String query2, String query3) {
        return findByFirstNameContainingOrLastNameContainingOrEmailContaining(query, query2, query3);
    }

    @Query("SELECT u FROM UserEntity u WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%',:query,'%'))"
            + " OR LOWER(u.lastName) LIKE LOWER(CONCAT('%',:query,'%'))"
            + " OR LOWER(u.email) LIKE LOWER(CONCAT('%',:query,'%'))")
    List<UserEntity> searchByQuery(@Param("query") String query);
}

