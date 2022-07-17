package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip 10 % discount")
    void vip_ok(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);

    }

//    @Test
//    void vip_no(){
//        //given
//        Member member = new Member(1L, "memberVIP", Grade.BASIC);
//        //when
//        int discount = discountPolicy.discount(member, 10000);
//        //then
//        assertThat(discount).isEqualTo(1000);
//    }
}