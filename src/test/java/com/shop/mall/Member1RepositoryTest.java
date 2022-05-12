package com.shop.mall;

import com.shop.mall.domain.Member1;
import com.shop.mall.domain.Member2Repository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Member1RepositoryTest {
    @Autowired
    Member2Repository member2Repository;
    @Test
    @Transactional  //test에 있으면 db rollback을 해버린다.
    @Rollback(false)
    public void testMember2() throws Exception{
        //given
        Member1 member1 = new Member1();
        member1.setUsername("memberA");

        //when
        Long savedid = member2Repository.save(member1);
        Member1 findMember1 = member2Repository.find(savedid);

        //then
        Assertions.assertThat(findMember1.getId()).isEqualTo(member1.getId());
        Assertions.assertThat(findMember1.getUsername()).isEqualTo(member1.getUsername());
        Assertions.assertThat(findMember1).isEqualTo(member1); //같은 영속성 컨텍스트 안에서 식별자가 같으니 같은 엔티티로 봄
                                                               // 1차 캐시에서봄. 쿼리도안날림 ㅇㅇ

    }


}