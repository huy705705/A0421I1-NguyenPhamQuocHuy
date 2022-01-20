package com.example.casestudy2.service.customer.impl;

import com.example.casestudy2.model.customer.Customer;
import com.example.casestudy2.repository.customer.CustomerRepository;
import com.example.casestudy2.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        return customerRepository.findAllByCustomerNameContaining(name);
    }

    @Override
    public Page<Customer> searchCustomerByName(String name, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContaining(name,pageable);
    }


}
