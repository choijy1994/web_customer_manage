package com.querencia.customer.demo.webService;

import com.querencia.customer.demo.domain.CustomerDto;
import com.querencia.customer.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class webRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/hello")
    public CustomerDto hello(){
        return customerService.selectCustomerByName("한민지");
    }
}
