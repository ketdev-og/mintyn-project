package com.orders.mintyn_order.repositories;



import com.orders.mintyn_order.dto.MintynOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<MintynOrder, Long> {
    List<MintynOrder> findByCreateDateBetween(Date startDate, Date endDate);
}
