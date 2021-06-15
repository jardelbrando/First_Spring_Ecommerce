package com.riftshop.riftshop.controllers;

import com.riftshop.riftshop.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView ShowHome(User user){
            return new ModelAndView ("home/index.html");
    }

//    @GetMapping("/home/loadProduct")
//    public  ModelAndView ShowFigther(User user) {return  new ModelAndView("ProductPages/Figther.html");}
}
