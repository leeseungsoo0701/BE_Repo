package com.shop.mall.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address1 {
    //이거 db에 어떻게 저장되는지 함 봐라 ㅇㅇ
    private String city;
    private String street;
    private String zipcode;

}
