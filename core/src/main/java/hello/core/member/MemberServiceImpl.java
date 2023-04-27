package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private  MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        // MemberServiceImpl 생성자를 만들면 MemberServiceImpl객체를 생성과 동시에
        // MemberServiceImpl이 의존하고 있는 DB를 생성자의 인자를 통해서 넣어줄 수 있다.
        this.memberRepository = memberRepository;
    }
    // 스프링빈의 value가 중복될때 그 value객체가 싱글톤을 따르는지를 알아보기 위한 테스트
    // memberService -> new MemoryMemberRepository();
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

    public void join(Member member){
        memberRepository.save(member);
    }

    public Member findMember(Long memberId){
        return memberRepository.findById(memberId);
    }

}
