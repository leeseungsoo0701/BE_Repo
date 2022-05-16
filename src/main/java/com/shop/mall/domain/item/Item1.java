package com.shop.mall.domain.item;

import com.shop.mall.domain.Category1;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "items1")
    private List<Category1> category1s = new ArrayList<>();

}
