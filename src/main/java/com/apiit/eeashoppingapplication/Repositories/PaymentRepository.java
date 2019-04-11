package com.apiit.eeashoppingapplication.Repositories;

import com.apiit.eeashoppingapplication.Models.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, String> {
}

