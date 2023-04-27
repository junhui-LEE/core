package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {
 //   MemberService memberService = new MemberServiceImpl();
  MemberService memberService;
   @BeforeEach
   public void beforeEach(){
       AppConfig appConfig = new AppConfig();
       memberService = appConfig.memberService();
    }
   @Test
    void join(){
       // given : 이러한 요소들이 주어지고
       Member member = new Member(1L, "memberA", Grade.VIP);
       // when : 어떤 행위를 했을때
       memberService.join(member);
       Member findMember = memberService.findMember(1L);
       // then : 이렇게 된다.
       Assertions.assertThat(member).isEqualTo(findMember);

   }

}
