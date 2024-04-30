package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    //MemberService memberService = new MemberServiceImpl();
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    MemberService memberService;

    @BeforeEach
    void setUp(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void createOrder() {

        //given
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);
        Member memberB = new Member(2L, "memberB", Grade.BAISC);
        memberService.join(memberB);

        //when
        int discountA = discountPolicy.discount(memberA, 20000);
        int discountB = discountPolicy.discount(memberB, 10000);

        //then
        Assertions.assertThat(discountA).isEqualTo(2000);
        Assertions.assertThat(discountB).isEqualTo(0);

        //vip 등급 고정 할인 금액

        //최종 할인 금액

    }
}