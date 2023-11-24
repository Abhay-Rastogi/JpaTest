package com.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.bean.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
