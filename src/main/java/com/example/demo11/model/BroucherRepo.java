package com.example.demo11.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BroucherRepo extends JpaRepository<Broucher, Long> {

	List<Broucher> findAllByBrandName(String brandName);
	
	 @Query("SELECT l FROM Broucher l WHERE l.brandName = :brandName AND l.quantity = :quantity AND l.priceType = :priceType")
	    Optional<Broucher> findByBrandNameAndQuantityAndLiquorType(
	        @Param("brandName") String brandName,
	        @Param("quantity") int quantity,
	        @Param("priceType") String priceType
	    );
	 
	 @Transactional
	    @Modifying
	    @Query("DELETE FROM Broucher l WHERE l.brandName = :brandName AND l.quantity = :quantity AND l.priceType = :priceType")
	    int deleteByBrandNameAndQuantityAndLiquorType(
	        @Param("brandName") String brandName,
	        @Param("quantity") int quantity,
	        @Param("priceType") String priceType
	    );
} 
