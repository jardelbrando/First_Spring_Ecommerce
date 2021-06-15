package com.riftshop.riftshop.repos;

import com.riftshop.riftshop.models.Role;
import org.springframework.data.repository.Repository;


public interface RoleRepository extends Repository<Role, Integer> {
    Role findByName(String name);
}
