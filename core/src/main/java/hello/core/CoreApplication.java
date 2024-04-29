package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
		System.out.println("Hell World");

		MemberService memberService = new MemberServiceImpl();

		Member member = new Member(1L, "A", Grade.VIP);
		memberService.join(member);
		Member A = memberService.findMember(1L);

		System.out.println("memberA : " + A.getName());
		System.out.println("member : " + A.getName());
	}
}