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
import org.springframework.context.annotation.Configuration;

@Configuration
// AppConfig : 구현체들끼리의 의존관계를 설정하는 클래스
public class AppConfig {
    @Bean
    public MemberService memberService() {
        // memberService()메소드를 실행시키면 MemberService역할을 하는 구현체로 MemberServiceImpl을
        // 설정해 준다.
        System.out.println("call AppConfig.memberService"); // 싱글톤 패턴인지를 확인하기 위해서 추가했다.
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        // memberRepository()메소드를 실행시키면 MemberRepository역할을 하는 구현체로 MemoryMemberRepository를
        // 설정해 준다.
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        // discountPolicy()메소드를 실행시키면 DiscountPolicy역할을 하는 구현체로 FixDiscountPolicy()을
        // 설정해 준다.
     //   return new FixDiscountPolicy();
          return new RateDiscountPolicy();
    }

}
