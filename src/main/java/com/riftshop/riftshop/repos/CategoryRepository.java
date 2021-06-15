package com.riftshop.riftshop.repos;

import com.riftshop.riftshop.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Integer>{
    
}
