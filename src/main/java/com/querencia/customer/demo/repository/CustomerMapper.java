package com.querencia.customer.demo.repository;

import com.querencia.customer.demo.domain.CustomerDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerMapper {
    CustomerDto selectCustomerByName(String name);
}
