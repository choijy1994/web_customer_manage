package com.querencia.customer.demo.repository;

import com.querencia.customer.demo.domain.CustomerDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerMapper {
    CustomerDto selectCustomerByName(String name);
    CustomerDto selectCustomerByPhone(String phoneNumber);
    List<CustomerDto> allCustomer();
    void insertCustomer(CustomerDto customer);
    void addStamp(String name, String phoneNumber);
    void useCoupon(String name, String phoneNumber);
}
