package com.shop.mall.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class Member2Repository {

    @PersistenceContext
    private EntityManager em;       // 스프링부트가 다 만들어줘서 em 생성하는 코드가 필요 없음

    public Long save(Member1 member1){
        em.persist(member1);
        return member1.getId(); // commend랑 query를 분리.
    }

    public Member1 find(Long id){
        return em.find(Member1.class, id);
    }
}
