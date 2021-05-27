package reactproject.demo.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void loginProcess(MemberController.MemberLoginDto memberLoginDto) {

    }

    public void register(MemberController.MemberRegisterDto memberRegisterDto) {
        String password = passwordEncoder.encode(memberRegisterDto.getPassword());
        Member member = new Member(memberRegisterDto.getName(), memberRegisterDto.getEmail(), password);

        memberRepository.save(member);

    }

    public void login(Member member) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                new UserMember(member),
                member.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE USER")));

        SecurityContextHolder.getContext().setAuthentication(token);
    }
}
