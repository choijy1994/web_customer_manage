package com.querencia.customer.demo.domain;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@NoArgsConstructor
@Alias("Customer")
@EqualsAndHashCode(exclude = {"regDate", "modDate", "stamp","couponNum"})
public class CustomerDto {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    private String name;
    private String phoneNumber;
    private int stamp = 0;
    private int couponNum = 0;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    @Builder
    public CustomerDto(String name, String phoneNumber, String regDate, String modDate){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.regDate = LocalDateTime.parse(regDate, FORMATTER);
        this.modDate = LocalDateTime.parse(modDate, FORMATTER);
    }

    public CustomerDto(String name, String phoneNumber, int stamp, int couponNum, String regDate, String modDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.stamp = stamp;
        this.couponNum = couponNum;
        this.regDate = LocalDateTime.parse(regDate, FORMATTER);
        this.modDate = LocalDateTime.parse(modDate, FORMATTER);
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

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getStamp() {
        return stamp;
    }

    public int getCouponNum() {
        return couponNum;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public LocalDateTime getModDate() {
        return modDate;
    }
}
