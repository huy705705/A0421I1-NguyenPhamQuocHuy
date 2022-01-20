package com.example.casestudy2.repository.customer;

import com.example.casestudy2.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByCustomerNameContaining(String customerName);
    Page<Customer> findAllByCustomerNameContaining(String customerName, Pageable pageable);
}
