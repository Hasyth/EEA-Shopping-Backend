package com.apiit.eeashoppingapplication.Repositories;


import com.apiit.eeashoppingapplication.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findUserByEmail(String email);

    boolean existsByEmail(String email);
}
