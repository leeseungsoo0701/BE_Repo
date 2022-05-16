package com.shop.mall.domain;

import com.shop.mall.domain.item.Item1;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItem1 {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item1 item1;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order1 order1;

    private int orderPrice;
    private int count;

}
