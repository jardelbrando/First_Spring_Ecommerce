package com.riftshop.riftshop.validators;

import com.riftshop.riftshop.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass){
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors){
        ValidationUtils.rejectIfEmpty(errors, "name", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "password", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "cpf", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "birth", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "cep", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "city", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "district", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "street", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "number", "field.required");

        User user = (User) object;

        if(!errors.hasFieldErrors("password") && user.getPassword().length() < 6)
            errors.rejectValue("password", "field.size");
    }
}
