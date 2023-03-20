package com.example.repositories;


import com.example.dto.MintynProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<MintynProduct, Long> {
    boolean existsMintynProductByProductId(String productId);
    MintynProduct findMintynProductByProductId(String productId);
}
