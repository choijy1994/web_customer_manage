package com.querencia.customer.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(exclude = {"regDate", "modDate", "stamp","couponNum"})
public class Customer {
    private String name;
    private String phoneNumber;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private int stamp = 0;
    private int couponNum = 0;

    @Builder
    public Customer(String name, String phone_number, LocalDateTime regDate, LocalDateTime modDate){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.regDate = regDate;
        this.modDate = modDate;
    }

    public void stampConvertCoupon(){
        if(stamp >= 10){
            stamp -= 10;
            couponNum += 1;
        }
    }

    public boolean useCoupon(){
        if(couponNum >= 1){
            couponNum -= 1;
        }else{
            return false;
        }
        return true;
    }
}
