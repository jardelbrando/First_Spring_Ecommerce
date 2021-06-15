package com.riftshop.riftshop.services.product;

import com.riftshop.riftshop.models.Product;
import com.riftshop.riftshop.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsLoad {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> loadProduct(){
        return (List<Product>) productRepository.findAll();
    }
}
