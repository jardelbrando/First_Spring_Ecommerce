package com.riftshop.riftshop.repos;

import com.riftshop.riftshop.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

    boolean existsByEmail(String email);
}
