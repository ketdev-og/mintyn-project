package com.orders.mintyn_order.repositories;




import com.orders.mintyn_order.dto.MintynProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<MintynProduct, Long> {
    MintynProduct findMintynProductByProductId(String productId);
}
