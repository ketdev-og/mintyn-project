package com.example.services.impl;

import com.example.dto.MintynProduct;
import com.example.exception.BadRequest;
import com.example.exception.NotFound;
import com.example.repositories.ProductRepository;
import com.example.services.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional
    public MintynProduct createProduct(MintynProduct product) {
        if (product == null)
            throw new BadRequest("product infomation is incorrect or empty");

        boolean productExist = productRepository.existsMintynProductByProductId(product.getProductId());
        if (productExist)
            throw new BadRequest("product already exist");

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public List<MintynProduct> getproducts() {
        return productRepository.findAll();
    }

    @Transactional
    @Override
    public MintynProduct updateProduct(String productId, MintynProduct product) {
        if (productId == null)
            throw new BadRequest("provide product id");

        MintynProduct savedProduct = productRepository.findMintynProductByProductId(productId);
        if (ObjectUtils.isEmpty(product))
            throw new NotFound("product not found");

        savedProduct.setName(product.getName());
        savedProduct.setDescription(product.getDescription());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setQuantity(product.getQuantity());



        return productRepository.save(savedProduct);
    }

}
