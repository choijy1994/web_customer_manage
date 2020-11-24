package com.querencia.customer.demo.webService;

import com.querencia.customer.demo.domain.CustomerDto;
import com.querencia.customer.demo.service.CustomerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class webRestController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/findByName", method= RequestMethod.GET)
    public CustomerDto findByName(@Param("userName")String userName){
        String name = "홍길동";
        return customerService.selectCustomerByName(name);
    }
    @GetMapping("/findByPhone")
    public CustomerDto findByPhone(){
        return customerService.selectCustomerByPhone("01090104430");
    }
    @GetMapping("/findAll")
    public List<CustomerDto> findAll(){
        return customerService.allCustomer();
    }
    @GetMapping("/insertCustomer")
    public void insetCustomer(){
        //return customerService.insertCustomer();
    }

    @GetMapping("/addStamp")
    public void addStamp(){
    }

    @GetMapping("/useCoupon")
    public void useCoupon(){
    }
}
