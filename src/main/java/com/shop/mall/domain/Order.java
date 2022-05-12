package com.shop.mall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne  //연관관계의 주인을 설정해야하는데 fk를 가진곳으로 한다.
    @JoinColumn(name = "member_id")
    private Member1 member1;

    @Embedded
    private List<OrderItem> orderItems = new ArrayList<>();

    @Embedded
    private Delivary delivary;

    private LocalDateTime orderData;

    private OrderStatus status;
}
