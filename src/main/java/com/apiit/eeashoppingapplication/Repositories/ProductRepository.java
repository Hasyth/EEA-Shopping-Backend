package com.apiit.eeashoppingapplication.Repositories;

import com.apiit.eeashoppingapplication.Models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

}
