package com.querencia.customer.demo.service;

import com.querencia.customer.demo.domain.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void crudTest(){
        CustomerDto dtos = customerService.selectCustomerByName("홍길동");
        assertThat(dtos.getPhoneNumber()).isEqualTo("01090104430");
    }
}