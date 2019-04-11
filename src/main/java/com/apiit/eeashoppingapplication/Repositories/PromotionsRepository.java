package com.apiit.eeashoppingapplication.Repositories;

import com.apiit.eeashoppingapplication.Models.Promotions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionsRepository extends CrudRepository<Promotions, String>{
}
