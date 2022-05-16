package com.shop.mall.domain;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Orders2Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_detail_id")
    private Long id;

    @Column(name = "option_content")
    private String optionContent;

    @Column
    private int ea;

    @Column
    private int bill;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders2 orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product2 product;

}
