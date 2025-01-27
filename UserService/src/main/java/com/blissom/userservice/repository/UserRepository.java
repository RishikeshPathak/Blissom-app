package com.blissom.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blissom.userservice.model.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {



	@Query("SELECT u FROM UserEntity u WHERE " +
	           "u.userName LIKE %:keyword% OR " +
	           "u.gender LIKE %:keyword% OR " +
	           "u.mobileNumber LIKE %:keyword% OR " +
	           "u.lastName LIKE %:keyword% OR " +
	           "u.nationality LIKE %:keyword% OR " +
	           "u.gender LIKE %:keyword% OR " +
	           "u.occupation LIKE %:keyword% OR " +
	           "u.countryCode LIKE %:keyword% OR " +
	           "u.firstName LIKE %:keyword% OR " +
	           "u.maritalStatus LIKE %:keyword%")
	    List<UserEntity> searchByKeyword(@Param("keyword") String keyword);

    boolean existsByReferralCode(String referralCode);


	//List<UserEntity> findTopUsersByActivity(int limit);

    @Query("SELECT COUNT(u) FROM UserEntity u WHERE u.accountStatus = :status")
    int countByAccountStatus(@Param("status") String status);

}
