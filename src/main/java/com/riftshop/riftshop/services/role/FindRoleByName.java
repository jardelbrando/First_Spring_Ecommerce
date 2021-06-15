package com.riftshop.riftshop.services.role;

import com.riftshop.riftshop.models.Role;
import com.riftshop.riftshop.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindRoleByName {
    @Autowired
    private RoleRepository repository;

    public Role execute(String name){
        return repository.findByName(name);
    }
}
