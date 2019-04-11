package com.apiit.eeashoppingapplication.Repositories;


import com.apiit.eeashoppingapplication.Models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {

}
