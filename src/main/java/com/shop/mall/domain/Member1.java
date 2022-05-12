package com.shop.mall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
public class Member1 {
    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    private String username;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member1")    //order table의 member2에 참조되었다.
    private List<Order> orders = new ArrayList<>();

}
