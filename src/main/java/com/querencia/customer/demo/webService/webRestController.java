package com.querencia.customer.demo.webService;

import com.querencia.customer.demo.domain.CustomerDto;
import com.querencia.customer.demo.service.CustomerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class webRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/findByName")
    public CustomerDto findByName(@Param("userName")String userName){
        return customerService.selectCustomerByName("홍길동");
    }
    @GetMapping("/findByPhone")
    public CustomerDto findByPhone(){
        return customerService.selectCustomerByPhone("홍길동");
    }
    @GetMapping("/findAll")
    public List<CustomerDto> findAll(){
        return customerService.allCustomer();
    }
    @GetMapping("/insertCusomer")
    public void insetCustomer(){
        //return customerService.insertCoustomer();
    }

    @GetMapping("/addStamp")
    public void findByName(){
    }

    @GetMapping("/useCoupon")
    public void useCoupon(){
    }
}
