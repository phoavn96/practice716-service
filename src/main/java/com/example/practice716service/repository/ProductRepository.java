package com.example.practice716service.repository;

import com.example.practice716service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Integer> {
//    @Modifying
//    @Query("update Product p set p.quantity = ?2 where p.Id = ?1")
//    void setProductQuantity(int productId, int quantity);
}
