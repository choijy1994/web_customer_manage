package com.querencia.customer.demo.service;

import com.querencia.customer.demo.domain.CustomerDto;
import com.querencia.customer.demo.repository.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public CustomerDto selectCustomerByName(String name){
        return customerMapper.selectCustomerByName(name);
    }

    public CustomerDto selectCustomerByPhone(String phoneNumber){
        return customerMapper.selectCustomerByPhone(phoneNumber);
    }
    public List<CustomerDto> allCustomer(){
        return customerMapper.allCustomer();
    }
    public void insertCustomer(String name, String phoneNumber, int stamp, int couponNum, String regDate, String modDate){
        CustomerDto customer = new CustomerDto(
                name,
                phoneNumber,
                stamp,
                couponNum,
                regDate,
                modDate
        );
        customerMapper.insertCustomer(customer);
    }
    public void addStamp(String name, String phoneNumber){
        customerMapper.addStamp(name, phoneNumber);
    }

    public void useCoupon(String name, String phoneNumber){
        customerMapper.useCoupon(name, phoneNumber);
    }
}
