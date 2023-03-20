package com.orders.mintyn_order.services.impl;




import com.orders.mintyn_order.dto.MintynOrder;
import com.orders.mintyn_order.dto.MintynProduct;
import com.orders.mintyn_order.entities.order.OrderRequest;
import com.orders.mintyn_order.exception.BadRequest;
import com.orders.mintyn_order.repositories.OrderRepository;
import com.orders.mintyn_order.repositories.ProductRepository;
import com.orders.mintyn_order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.orders.mintyn_order.utils.Helpers.genRandomId;


@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Transactional
    @Override
    public MintynOrder createOrder(OrderRequest order) {
        if (order == null)
            throw new BadRequest("order infomation is incorrect or empty");

        Set<MintynProduct> products = new HashSet<>();

        for (String x : order.getProducts()) {
            MintynProduct product = productRepository.findMintynProductByProductId(x);
            if (!ObjectUtils.isEmpty(product)) {
                products.add(product);
            }
        }

        MintynOrder newOrder = MintynOrder.builder()
                .orderId(genRandomId("ORD"))
                .customerName(order.getCustomerName())
                .customerPhone(order.getCustomerPhone())
                .totalPrice(order.getTotalPrice())
                .products(products)
                .build();

        return orderRepository.save(newOrder);
    }

    @Override
    public List<MintynOrder> orders() {
        return orderRepository.findAll();
    }
}
