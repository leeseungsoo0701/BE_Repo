package com.shop.mall;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class Member2Repository {

    @PersistenceContext
    private EntityManager em;       // 스프링부트가 다 만들어줘서 em 생성하는 코드가 필요 없음

    public Long save(Member2 member2){
        em.persist(member2);
        return member2.getId(); // commend랑 query를 분리.
    }

    public Member2 find(Long id){
        return em.find(Member2.class, id);
    }
}
