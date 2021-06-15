package com.riftshop.riftshop.controllers;

import com.riftshop.riftshop.models.User;
import com.riftshop.riftshop.services.user.StoreUser;
import com.riftshop.riftshop.services.user.UserAuthenticated;
import com.riftshop.riftshop.services.utils.Message;
import com.riftshop.riftshop.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private StoreUser storeUser;

    @Autowired
    private UserAuthenticated userAuthenticated;

    @InitBinder("user")
    public void initUserBinder(WebDataBinder binder){
        binder.setValidator(new UserValidator());
    }


    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("login/index");
    }

    @GetMapping("/signup")
    public ModelAndView signup(User user){
        return new ModelAndView("signup/index").addObject("user", user);
    }

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        //The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(Date.class, editor);
    }

    @PostMapping("/signup")
    public ModelAndView store(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return signup(user).addObject("message", Message.fieldsErrors());
        }
        storeUser.execute(user);
        return new ModelAndView("login/index");
    }
}
