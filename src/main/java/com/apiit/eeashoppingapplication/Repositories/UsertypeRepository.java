package com.apiit.eeashoppingapplication.Repositories;

import com.apiit.eeashoppingapplication.Models.Usertype;
import org.springframework.data.repository.CrudRepository;

import javax.management.relation.Role;

public interface UsertypeRepository extends CrudRepository<Usertype, String> {
}
