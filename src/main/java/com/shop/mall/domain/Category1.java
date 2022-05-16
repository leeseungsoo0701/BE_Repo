package com.shop.mall.domain;


import com.shop.mall.domain.item.Item1;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Category1 {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category1_id"),
            inverseJoinColumns = @JoinColumn(name = "item1_id")) //관계형 db는 콜렉션관계를 서로 가질수 없기때문에 일대다 다대일로 풀어야한다.
    private List<Item1> items1 = new ArrayList<>(); //mappedBy를 잡을때 클래스가 아닌 객체명으로 잡아준다.


    
}
