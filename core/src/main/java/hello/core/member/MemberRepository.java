package hello.core.member;

public interface MemberRepository {
    // DB가 정해지지 않아서 나중에 DB를 갈아서 낄 것인데
    // 우선 저장소의 역할은

    // 1. 회원을 저장한다.
    void save(Member member);
    // 2. Id로 회원을 찾는다.
    Member findById(Long memberId);

}
