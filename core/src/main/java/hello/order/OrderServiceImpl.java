package hello.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    MemberRepository memberRepository = new MemoryMemberRepository();
    DiscountPolicy discountPolicy = new FixDiscountPolicy();

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
