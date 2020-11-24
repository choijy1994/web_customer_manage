package com.querencia.customer.demo.webService;

import com.querencia.customer.demo.domain.CustomerDto;
import com.querencia.customer.demo.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class webRestController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "이름으로 찾기", notes = "성공시 해당 이름을 가진 고객이 찾아집니")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
    })
    @ResponseBody
    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.POST)
    public HashMap<String, Object> findByName(@RequestParam(value = "userName", required = true) String name) {
        HashMap<String, Object> answer = new HashMap<>();
        CustomerDto customer = customerService.selectCustomerByName(name);
        if (customer != null) {
            answer.put("code", 200);
            answer.put("result", customer);
        }else{
            answer.put("code", 400);
            answer.put("result", "can not find customer");
        }
        return answer;
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
