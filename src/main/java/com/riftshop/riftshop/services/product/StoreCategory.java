package com.riftshop.riftshop.services.product;

import com.riftshop.riftshop.models.Category;
import com.riftshop.riftshop.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreCategory {

    @Autowired
    public CategoryRepository repository;

    public void execute(Category category){
        repository.save(category);
    }
}
