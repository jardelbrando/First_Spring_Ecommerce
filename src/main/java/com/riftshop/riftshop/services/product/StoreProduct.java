package com.riftshop.riftshop.services.product;

import com.riftshop.riftshop.models.Category;
import com.riftshop.riftshop.models.Product;
import com.riftshop.riftshop.repos.CategoryRepository;
import com.riftshop.riftshop.repos.ProductRepository;
import org.aspectj.util.PartialOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StoreProduct {

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public ProductRepository repository;

    public void execute(Product product, String categories2){
        String[] items = categories2.replaceAll("\\[","").replaceAll("]", "").split(",");

        int[] results = new int[items.length];

        for (int i = 0; i < items.length; i++) {
                results[i] = Integer.parseInt(items[i]);
        }
        Set<Category> categories = new HashSet<>();

        for(int id: results) {
            Optional<Category> category = categoryRepository.findById(id);
            if(category.isPresent()){
                Category _category = category.get();

                categories.add(_category);
            }

        }
        try {
            product.setCategories(categories);
            repository.save(product);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
