package com.shop.mall;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Member2RepositoryTest {
    @Autowired Member2Repository member2Repository;
    @Test
    @Transactional  //test에 있으면 db rollback을 해버린다.
    @Rollback(false)
    public void testMember2() throws Exception{
        //given
        Member2 member2 = new Member2();
        member2.setUsername("memberA");

        //when
        Long savedid = member2Repository.save(member2);
        Member2 findMember2 = member2Repository.find(savedid);

        //then
        Assertions.assertThat(findMember2.getId()).isEqualTo(member2.getId());
        Assertions.assertThat(findMember2.getUsername()).isEqualTo(member2.getUsername());
        Assertions.assertThat(findMember2).isEqualTo(member2); //같은 영속성 컨텍스트 안에서 식별자가 같으니 같은 엔티티로 봄
                                                               // 1차캐시에서봄. 쿼리도안날림 ㅇㅇ

    }


}