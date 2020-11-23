package com.querencia.customer.demo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Data
@Alias("Customer")
@EqualsAndHashCode(exclude = {"regDate", "modDate", "stamp","couponNum"})
public class CustomerDto {
    private String name;
    private String phoneNumber;
    private int stamp = 0;
    private int couponNum = 0;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    @Builder
    public CustomerDto(String name, String phone_number, LocalDateTime regDate, LocalDateTime modDate){
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
