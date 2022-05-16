package com.shop.mall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery1 {

    @Id @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy="delivery1")
    private Order1 order1;

    @Embedded
    private Address1 address1;

//    @Enumerated(EnumType.ORDINAL) >> enum선언 할때 써야하는 어노테이션 디폴트는 ordinal >> 숫자로들어감
// 중간에 다른 상태가 추가된경우 데이터가 꼬일 수 있어서 망함.. 그래서 ordinal 절대 씀녀 안됨
    @Enumerated(EnumType.STRING)
    private Delivery1Status status; // ready, comp
}
