package com.querencia.customer.demo.service;

import com.querencia.customer.demo.domain.CustomerDto;
import com.querencia.customer.demo.repository.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public CustomerDto selectCustomerByName(String name){
        return customerMapper.selectCustomerByName(name);
    }
}
