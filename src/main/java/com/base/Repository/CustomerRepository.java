package com.base.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.base.Model.Customer;
 
 
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
}