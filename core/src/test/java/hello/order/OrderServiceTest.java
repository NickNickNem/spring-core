package hello.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {

        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order =  orderService.createOrder(1L, "testItem", 10000);

        //then

        //vip 등급 고정 할인 금액
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

        //최종 할인 금액
        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);

    }
}