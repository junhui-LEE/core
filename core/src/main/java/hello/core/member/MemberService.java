package hello.core.member;

public interface MemberService {
    // 회원과 관련된 업무(도메인, 영역)을 클라이언트, 회원 서비스, 메모리 회원 저장소
    // 이렇게 나누어서 개발을 하는데
    // 서비스 단(회원 서비스)에서는 두 가지 기능이 있다.

    // 1. 회원가입
    void join(Member member);
    // 2. 회원조회
    Member findMember(Long memberId);
}
