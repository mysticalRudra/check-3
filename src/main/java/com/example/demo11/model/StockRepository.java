package com.example.demo11.model;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockRepository extends JpaRepository<Stock, Long> {

    boolean existsByBrandAndQuantity(String brand, int quantity);
    
    Optional<Stock> findByBrandAndQuantity(String brand, int quantity);
    
    @Query("SELECT s FROM Stock s WHERE s.brand = :brand AND s.quantity = :quantity")
    Optional<Stock> findParticulars(@Param("brand") String brand, @Param("quantity") int quantity);

    
}
