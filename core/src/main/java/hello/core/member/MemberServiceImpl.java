package hello.core.member;

public class MemberServiceImpl implements  MemberService{

    //회원 저장소
    private final MemberRepository memberRepository;
    
    //의존성 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        Member member =  memberRepository.findById(memberId);
        return member;
    }
}
