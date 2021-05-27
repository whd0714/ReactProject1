package reactproject.demo.member;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @PostMapping("/api/login")
    public String loginProcess(@RequestBody MemberLoginDto memberLoginDto) {
        Member member = memberRepository.findByEmail(memberLoginDto.getEmail());
        if(member != null) {
            memberService.login(member);

            return "loginSuccess";
        }

        return "loginFail";
    }

    @PostMapping("/api/register")
    public String registerProcess(@RequestBody MemberRegisterDto memberRegisterDto){
        memberService.register(memberRegisterDto);

        return "회원가입 완료";
    }

    @GetMapping("/api/member/auth")
    public Member memberAuth(@CurrentUser Member member) {
        return member;
    }

    @Data
    static class MemberRegisterDto {
        private String name;
        private String email;
        private String password;
    }

    @Data
    static class MemberLoginDto {
        private String email;
        private String password;
    }
}
