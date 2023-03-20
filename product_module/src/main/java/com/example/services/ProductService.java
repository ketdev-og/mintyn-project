package com.example.services;

import com.example.dto.MintynProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    MintynProduct createProduct(MintynProduct product);
    List<MintynProduct> getproducts();
    MintynProduct updateProduct(String ProductId, MintynProduct product);
}
