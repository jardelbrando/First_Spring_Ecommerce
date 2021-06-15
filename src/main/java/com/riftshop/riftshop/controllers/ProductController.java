package com.riftshop.riftshop.controllers;

import com.riftshop.riftshop.models.Category;
import com.riftshop.riftshop.models.Product;
import com.riftshop.riftshop.models.User;
import com.riftshop.riftshop.repos.CategoryRepository;
import com.riftshop.riftshop.repos.ProductRepository;
import com.riftshop.riftshop.services.product.ProductsLoad;
import com.riftshop.riftshop.services.product.StoreCategory;
import com.riftshop.riftshop.services.product.StoreProduct;
import com.riftshop.riftshop.services.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private StoreProduct storeProduct;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public CategoryRepository repository;

    @Autowired
    private ProductsLoad productsLoad;

    @GetMapping("/home/productRegister")
    public ModelAndView signupProduct (Product product){
        List<Category> categories = (List<Category>) repository.findAll();

        return new ModelAndView("/loggedUser/productRegister").addObject("product", product)
                .addObject("categories", categories);
    }

    @PostMapping("/home/productRegister")
    public ModelAndView storeProduct (@Valid Product product, @RequestParam String categories_name, BindingResult result){
        if(result.hasErrors()){
            return signupProduct(product).addObject("message", Message.fieldsErrors());
        }

        storeProduct.execute(product, categories_name);
        return new ModelAndView("/home/index");
    }

    @GetMapping("/loadProducts")
    public ModelAndView loadProduct (User user){
        List<Product> products;
        products = productsLoad.loadProduct();
        return new ModelAndView("/ProductPages/Figther").addObject("products", products);
    }

}
