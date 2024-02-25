package com.example.productservicemicroservice.service;

import com.example.productservicemicroservice.dto.ProductRequest;
import com.example.productservicemicroservice.dto.ProductResponse;
import com.example.productservicemicroservice.models.Product;
import com.example.productservicemicroservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = new Product().builder()
                        .name(productRequest.getName())
                        .description(productRequest.getDescription())
                        .price(productRequest.getPrice())
                        .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> showAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product){
        ProductResponse productResponse = new ProductResponse(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
        return productResponse;
    }
}
