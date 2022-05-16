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
public class Order1 {

    @Id
    @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne  //연관관계의 주인을 설정해야하는데 fk를 가진곳으로 한다.
    @JoinColumn(name = "member_id")
    private Member1 member1;

    @OneToMany(mappedBy = "order1")
    private List<OrderItem1> orderItems1 = new ArrayList<>();

    @OneToOne   // one to one의 경우 더 많이 쓸것 같은 곳에 fk를 둔다.
    @JoinColumn(name = "delivery_id")
    private Delivery1 delivery1;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus1 status;
}
