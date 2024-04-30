package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {

		SpringApplication.run(CoreApplication.class, args);
		System.out.println("Hell World");

		//AppConfig appConfig = new AppConfig();
		//MemberService memberService = appConfig.memberService();
		//OrderService orderService = appConfig.orderService();

		//AppConfig에 있는 설정 정보로 스프링 컨테이너에 넣어서 관리
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
		OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

		Member member = new Member(1L, "A", Grade.VIP);
		memberService.join(member);
		Member A = memberService.findMember(1L);

		System.out.println("memberA : " + A.getName());
		System.out.println("member : " + A.getName());

		Order order = orderService.createOrder(1L, "testItem", 10000);
		System.out.println("order : " + order);
	}
}