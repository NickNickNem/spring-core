package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    //의존성 주입
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        //회원 ID 조회
        Member member = memberRepository.findById(memberId);

        //회원 정보 기반으로 등급 조회 & 할인 금액 반환
        int discountPrice = discountPolicy.discount(member, itemPrice);
        Order order = new Order(memberId, itemName, itemPrice, discountPrice);

        return order;
    }
}
