package com.orders.mintyn_order.repositories;



import com.orders.mintyn_order.dto.MintynOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<MintynOrder, Long> {
}
