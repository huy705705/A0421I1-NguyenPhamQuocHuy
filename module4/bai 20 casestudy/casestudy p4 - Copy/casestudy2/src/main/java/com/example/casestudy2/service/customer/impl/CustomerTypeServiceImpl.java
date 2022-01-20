package com.example.casestudy2.service.customer.impl;

import com.example.casestudy2.model.customer.CustomerType;
import com.example.casestudy2.repository.customer.CustomerRepository;
import com.example.casestudy2.repository.customer.CustomerTypeRepository;
import com.example.casestudy2.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
