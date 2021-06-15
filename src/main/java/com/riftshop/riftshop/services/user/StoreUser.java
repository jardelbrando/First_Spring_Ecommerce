package com.riftshop.riftshop.services.user;

import com.riftshop.riftshop.models.Role;
import com.riftshop.riftshop.models.User;
import com.riftshop.riftshop.repos.UserRepository;
import com.riftshop.riftshop.services.role.FindRoleByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StoreUser {

    @Autowired
    public UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private FindRoleByName findRoleByName;

    public void execute(User user){
        User userAlreadyExists = repository.findByEmail(user.getEmail());
        if(userAlreadyExists != null)
            System.out.println("Usuário já cadastrado com esse email!!");
        else{
            user.setPassword(encoder.encode(user.getPassword()));

            Role role = findRoleByName.execute("ROLE_USER");

            user.getRoles().add(role);

            repository.save(user);
        }

    }
}
