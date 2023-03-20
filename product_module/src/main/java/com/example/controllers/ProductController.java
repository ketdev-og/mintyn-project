package com.example.controllers;

import com.example.dto.MintynProduct;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.example.utils.constants.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<MintynProduct> createProduct(@RequestBody MintynProduct product) {
        MintynProduct newProduct = productService.createProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MintynProduct>> getProducts() {
        List<MintynProduct> products = productService.getproducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/update/{product_id}")
    public ResponseEntity<MintynProduct> updateProdct(
            @PathVariable("product_id") String productId,
            @RequestBody MintynProduct product
    ) {
        MintynProduct updatedProduct = productService.updateProduct(productId, product);
        return ResponseEntity.ok(updatedProduct);
    }

}
