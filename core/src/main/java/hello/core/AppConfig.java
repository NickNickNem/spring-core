package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    //생성자 주입
    //public MemberService memberService(){
    //    return new MemberServiceImpl(new MemoryMemberRepository());
    //}
    // OrderService 역할(생성자 주입)
    //public OrderService orderService(){
    //    return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    //}
    @Bean
    // 저장소의 역할
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    // 할인 정책의 역할
    public DiscountPolicy discountPolicy(){
        // 고정 할인
        //return new FixDiscountPolicy();
        // % 할인
        return new RateDiscountPolicy();
    }
    // MemberService 역할 (생성자 주입)
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    // OrderService 역할 (생성자 주입)
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
