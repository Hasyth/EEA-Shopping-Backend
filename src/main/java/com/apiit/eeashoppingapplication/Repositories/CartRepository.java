package com.apiit.eeashoppingapplication.Repositories;

import com.apiit.eeashoppingapplication.Models.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, String> {
}
