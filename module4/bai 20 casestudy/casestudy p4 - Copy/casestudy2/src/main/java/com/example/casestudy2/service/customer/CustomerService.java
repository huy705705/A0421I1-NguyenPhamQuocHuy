package com.example.casestudy2.service.customer;

import com.example.casestudy2.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Integer id);
    Customer save(Customer customer);
    void deleteById(Integer id);
    List<Customer>  searchCustomerByName(String name);
    Page<Customer>  searchCustomerByName(String name,Pageable pageable);
}
