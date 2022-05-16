package com.shop.mall.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)    //싱글테이블전략으로 할거임
@DiscriminatorColumn(name="dtype")
@Getter @Setter
public abstract class Item1 {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;

    private int price;
    private int stockQuantity;

}
