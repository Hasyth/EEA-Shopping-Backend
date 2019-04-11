package com.apiit.eeashoppingapplication.Repositories;


import com.apiit.eeashoppingapplication.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
